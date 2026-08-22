package com.guoshisan.xiaohongshu.auth.service;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.auth.model.vo.verificationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {

    /**
     * 发送短信验证码
     *
     * @param sendVerificationCodeReqVO
     * @return
     */
    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
