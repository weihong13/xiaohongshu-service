package com.guoshisan.xiaohongshu.user.biz.service;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;

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
}
