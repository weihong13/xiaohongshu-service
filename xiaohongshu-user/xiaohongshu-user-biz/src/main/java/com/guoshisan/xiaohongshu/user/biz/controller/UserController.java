package com.guoshisan.xiaohongshu.user.biz.controller;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.biz.model.vo.UpdateUserInfoReqVO;
import com.guoshisan.xiaohongshu.user.biz.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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

}

