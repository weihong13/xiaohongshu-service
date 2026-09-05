package com.guoshisan.xiaohongshu.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UpdatePasswordReqVO;
import com.guoshisan.xiaohongshu.auth.model.vo.user.UserLoginReqVO;
import com.guoshisan.xiaohongshu.auth.service.IUserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    private IUserService iUserService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return iUserService.loginAndRegister(userLoginReqVO);
    }

    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout() {
        return iUserService.logout();
    }

    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改密码")
    public Response<?> updatePassword(@Validated @RequestBody UpdatePasswordReqVO updatePasswordReqVO) {
        return iUserService.updatePassword(updatePasswordReqVO);
    }

}
