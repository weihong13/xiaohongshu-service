package com.guoshisan.xiaohongshu.auth.controller;

import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.guoshisan.xiaohongshu.auth.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 郭拾叁
 * @date: 2026/5/29 15:32
 * @version: v1.0.0
 * @description: TODO
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private IUserService iuserService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return iuserService.loginAndRegister(userLoginReqVO);
    }

}

