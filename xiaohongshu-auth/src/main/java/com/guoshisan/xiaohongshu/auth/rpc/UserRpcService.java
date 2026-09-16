package com.guoshisan.xiaohongshu.auth.rpc;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.api.UserFeignApi;
import com.guoshisan.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.guoshisan.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author: 郭拾叁
 * @date: 2026/9/16 22:23
 * @version: v1.0.0
 * @description: 用户服务
 **/
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 用户注册
     *
     * @param phone
     * @return
     */
    public Long registerUser(String phone) {
        RegisterUserReqDTO registerUserReqDTO = new RegisterUserReqDTO();
        registerUserReqDTO.setPhone(phone);

        Response<Long> response = userFeignApi.registerUser(registerUserReqDTO);

        if (!response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

    /**
     * 根据手机号查询用户信息
     *
     * @param phone
     * @return
     */
    public FindUserByPhoneRspDTO findUserByPhone(String phone) {
        FindUserByPhoneReqDTO findUserByPhoneReqDTO = new FindUserByPhoneReqDTO();
        findUserByPhoneReqDTO.setPhone(phone);

        Response<FindUserByPhoneRspDTO> response = userFeignApi.findByPhone(findUserByPhoneReqDTO);

        if (!response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

    /**
     * 密码更新
     *
     * @param encodePassword
     */
    public void updatePassword(String encodePassword) {
        UpdateUserPasswordReqDTO updateUserPasswordReqDTO = new UpdateUserPasswordReqDTO();
        updateUserPasswordReqDTO.setEncodePassword(encodePassword);

        userFeignApi.updatePassword(updateUserPasswordReqDTO);
    }


}

