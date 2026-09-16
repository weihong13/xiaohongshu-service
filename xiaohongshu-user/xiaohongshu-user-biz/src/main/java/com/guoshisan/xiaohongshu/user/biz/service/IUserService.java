package com.guoshisan.xiaohongshu.user.biz.service;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.guoshisan.xiaohongshu.user.dto.req.FindUserByPhoneReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.RegisterUserReqDTO;
import com.guoshisan.xiaohongshu.user.dto.req.UpdateUserPasswordReqDTO;
import com.guoshisan.xiaohongshu.user.dto.resp.FindUserByPhoneRspDTO;

/**
 * @author: 郭拾叁
 * @date: 2026/9/11 21:41
 * @version: v1.0.0
 * @description: 用户业务
 **/
public interface IUserService {
    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    Response<Long> register(RegisterUserReqDTO registerUserReqDTO);

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    Response<FindUserByPhoneRspDTO> findByPhone(FindUserByPhoneReqDTO findUserByPhoneReqDTO);

    /**
     * 更新密码
     *
     * @param updateUserPasswordReqDTO
     * @return
     */
    Response<?> updatePassword(UpdateUserPasswordReqDTO updateUserPasswordReqDTO);
}
