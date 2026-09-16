package com.guoshisan.xiaohongshu.user.biz.controller;

import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.guoshisan.xiaohongshu.user.biz.service.IUserService;
import com.guoshisan.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.guoshisan.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 郭宏伟
 * @date: 2026/9/11 21:57
 * @version: v1.0.0
 * @description: 用户
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private IUserService iUserService;

    /**
     * 用户信息修改
     *
     * @param updateUserInfoReqVO
     * @return
     */
    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response<?> updateUserInfo(@Validated UpdateUserInfoReqVO updateUserInfoReqVO) {
        return iUserService.updateUserInfo(updateUserInfoReqVO);
    }

    // ===================================== 对其他服务提供的接口 =====================================
    @PostMapping("/register")
    @ApiOperationLog(description = "用户注册")
    public Response<Long> register(@Validated @RequestBody RegisterUserReqDTO registerUserReqDTO) {
        return iUserService.register(registerUserReqDTO);
    }

    @PostMapping("/findByPhone")
    @ApiOperationLog(description = "手机号查询用户信息")
    public Response<FindUserByPhoneRspDTO> findByPhone(@Validated @RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO) {
        return iUserService.findByPhone(findUserByPhoneReqDTO);
    }

    @PostMapping("/password/update")
    @ApiOperationLog(description = "密码更新")
    public Response<?> updatePassword(@Validated @RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO) {
        return iUserService.updatePassword(updateUserPasswordReqDTO);
    }


}

