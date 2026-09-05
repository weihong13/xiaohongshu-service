package com.guoshisan.xiaohongshu.auth.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.guoshisan.framework.biz.context.holder.LoginUserContextHolder;
import com.guoshisan.framework.common.enums.DeletedEnum;
import com.guoshisan.framework.common.enums.StatusEnum;
import com.guoshisan.framework.common.exception.BizException;
import com.guoshisan.framework.common.response.Response;
import com.guoshisan.framework.common.util.JsonUtils;
import com.guoshisan.xiaohongshu.auth.constant.RedisKeyConstants;
import com.guoshisan.xiaohongshu.auth.constant.RoleConstants;
import com.guoshisan.xiaohongshu.auth.domain.dto.PermissionDTO;
import com.guoshisan.xiaohongshu.auth.domain.dto.RoleDTO;
import com.guoshisan.xiaohongshu.auth.domain.dto.UserDTO;
import com.guoshisan.xiaohongshu.auth.domain.dto.UserRoleDTO;
import com.guoshisan.xiaohongshu.auth.mapper.RoleDTOMapper;
import com.guoshisan.xiaohongshu.auth.mapper.UserDTOMapper;
import com.guoshisan.xiaohongshu.auth.mapper.UserRoleDTOMapper;
import com.guoshisan.xiaohongshu.auth.enums.LoginTypeEnum;
import com.guoshisan.xiaohongshu.auth.enums.ResponseCodeEnum;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.guoshisan.xiaohongshu.auth.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @author: 犬小哈
 * @date: 2024/4/7 15:41
 * @version: v1.0.0
 * @description: TODO
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDTOMapper userDTOMapper;
    @Resource
    private RoleDTOMapper roleDTOMapper;
    @Resource
    private UserRoleDTOMapper userRoleDTOMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private TransactionTemplate transactionTemplate;
    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @Resource
    private PasswordEncoder passwordEncoder;
    /**
     * 登录与注册
     *
     * @param userLoginReqVO
     * @return
     */
    @Override
    public Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO) {
        String phone = userLoginReqVO.getPhone();
        Integer type = userLoginReqVO.getType();

        LoginTypeEnum loginTypeEnum = LoginTypeEnum.valueOf(type);

        Long userId = null;

        // 判断登录类型
        switch (loginTypeEnum) {
            case VERIFICATION_CODE: // 验证码登录
                String verificationCode = userLoginReqVO.getCode();

                // 校验入参验证码是否为空
                Preconditions.checkArgument(StringUtils.isNotBlank(verificationCode), "验证码不能为空");

                // 构建验证码 Redis Key
                String key = RedisKeyConstants.buildVerificationCodeKey(phone);
                // 查询存储在 Redis 中该用户的登录验证码
                String sentCode = (String) redisTemplate.opsForValue().get(key);

                // 判断用户提交的验证码，与 Redis 中的验证码是否一致
                if (!StringUtils.equals(verificationCode, sentCode)) {
                    throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_ERROR);
                }

                // 通过手机号查询记录
                UserDTO userDO = userDTOMapper.selectByPhone(phone);

                log.info("==> 用户是否注册, phone: {}, userDO: {}", phone, JsonUtils.toJsonString(userDO));

                // 判断是否注册
                if (Objects.isNull(userDO)) {
                    // 若此用户还没有注册，系统自动注册该用户
                    userId = registerUser(phone);
                } else {
                    // 已注册，则获取其用户 ID
                    userId = userDO.getId();
                }
                break;
            case PASSWORD: // 密码登录
                String password = userLoginReqVO.getPassword();
                // 根据手机号查询
                UserDTO userDTO1 = userDTOMapper.selectByPhone(phone);

                // 判断该手机号是否注册
                if (Objects.isNull(userDTO1)) {
                    throw new BizException(ResponseCodeEnum.USER_NOT_FOUND);
                }

                // 拿到密文密码
                String encodePassword = userDTO1.getPassword();

                // 匹配密码是否一致
                boolean isPasswordCorrect = passwordEncoder.matches(password, encodePassword);

                // 如果不正确，则抛出业务异常，提示用户名或者密码不正确
                if (!isPasswordCorrect) {
                    throw new BizException(ResponseCodeEnum.PHONE_OR_PASSWORD_ERROR);
                }

                userId = userDTO1.getId();
                break;
            default:
                break;
        }

        // SaToken 登录用户, 入参为用户 ID
        StpUtil.login(userId);

        // 获取 Token 令牌
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        // 返回 Token 令牌
        return Response.success(tokenInfo.tokenValue);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @Override
    public Response<?> logout() {
        Long userId = LoginUserContextHolder.getUserId();

        log.info("==> 用户退出登录, userId: {}", userId);

        threadPoolTaskExecutor.submit(() -> {
            Long userId2 = LoginUserContextHolder.getUserId();
            log.info("==> 异步线程中获取 userId: {}", userId2);
        });

        // 退出登录 (指定用户 ID)
        StpUtil.logout(userId);

        return Response.success();
    }

    /**
     * 修改密码
     *
     * @param updatePasswordReqVO
     * @return
     */
    @Override
    public Response<?> updatePassword(UpdatePasswordReqVO updatePasswordReqVO) {
        // 新密码
        String newPassword = updatePasswordReqVO.getNewPassword();
        // 密码加密
        String encodePassword = passwordEncoder.encode(newPassword);

        // 获取当前请求对应的用户 ID
        Long userId = LoginUserContextHolder.getUserId();
        if (Objects.isNull(userId)) {
            log.warn("==> 修改密码失败：请求上下文中未找到用户 ID");
            return Response.fail("请先登录");
        }

        UserDTO userDO = UserDTO.builder()
                .id(userId)
                .password(encodePassword)
                .updateTime(LocalDateTime.now())
                .build();
        // 更新密码
        userDTOMapper.updateByPrimaryKeySelective(userDO);

        return Response.success();
    }

    public static void main(String[] args) {
        ThreadLocal<Long> threadLocal = new InheritableThreadLocal<>();
        // 假设 用户 ID
        Long userId = 1L;
        threadLocal.set(userId);
        System.out.println("主线程打印用户 ID: " + threadLocal.get());

        new Thread(() -> {
            System.out.println("异步线程打印用户 ID: " + threadLocal.get());
        }).start();
    }

    /**
     * 系统自动注册用户
     * @param phone
     * @return
     */
    private Long registerUser(String phone) {
        return transactionTemplate.execute(status -> {
            try {
                // 获取全局自增的小哈书 ID
                Long xiaohongshuId = redisTemplate.opsForValue().increment(RedisKeyConstants.XIAOHONGSHU_ID_GENERATOR_KEY);

                UserDTO userDO = UserDTO.builder()
                        .phone(phone)
                        .xiaohongshuId(String.valueOf(xiaohongshuId)) // 自动生成小红书号 ID
                        .nickname("小红薯" + xiaohongshuId) // 自动生成昵称, 如：小红薯10000
                        .status(StatusEnum.ENABLE.getValue()) // 状态为启用
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .isDeleted(DeletedEnum.NO.getValue()) // 逻辑删除
                        .build();

                // 添加入库
                userDTOMapper.insert(userDO);

                // 获取刚刚添加入库的用户 ID
                Long userId = userDO.getId();

                // 给该用户分配一个默认角色
                UserRoleDTO userRoleDO = UserRoleDTO.builder()
                        .userId(userId)
                        .roleId(RoleConstants.COMMON_USER_ROLE_ID)
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .isDeleted(DeletedEnum.NO.getValue())
                        .build();
                userRoleDTOMapper.insert(userRoleDO);

                RoleDTO roleDO = roleDTOMapper.selectByPrimaryKey(RoleConstants.COMMON_USER_ROLE_ID);

                // 将该用户的角色 ID 存入 Redis 中
                List<String> roles = new ArrayList<>(1);
                roles.add(roleDO.getRoleKey());

                String userRolesKey = RedisKeyConstants.buildUserRoleKey(userId);
                redisTemplate.opsForValue().set(userRolesKey, JsonUtils.toJsonString(roles));

                return userId;
            } catch (Exception e) {
                status.setRollbackOnly(); // 标记事务为回滚
                log.error("==> 系统注册用户异常: ", e);
                return null;
            }
        });
    }

}
