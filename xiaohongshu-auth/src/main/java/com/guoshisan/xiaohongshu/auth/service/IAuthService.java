package com.guoshisan.xiaohongshu.auth.service;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UserLoginReqVO;

/**
 * @author: 郭拾叁
 * @date: 2026/8/22 21:01
 * @version: v1.0.0
 * @description: TODO
 **/
public interface IAuthService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout();

    /**
     * 修改密码
     * @param updatePasswordReqVO
     * @return
     */
    Response<?> updatePassword(UpdatePasswordReqVO updatePasswordReqVO);
}


