package com.guoshisan.xiaohongshu.user.api;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.constant.ApiConstants;
import com.guoshisan.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.guoshisan.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 22:11
 * @version: v1.0.0
 * @description: TODO
 **/
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface UserFeignApi {

    String PREFIX = "/user";

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/register")
    Response<Long> registerUser(@RequestBody RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/findByPhone")
    Response<FindUserByPhoneRspDTO> findByPhone(@RequestBody FindUserByPhoneReqDTO findUserByPhoneReqDTO);

    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/password/update")
    Response<?> updatePassword(@RequestBody UpdateUserPasswordReqDTO updateUserPasswordReqDTO);
}
