package com.guoshisan.xiaohongshu.auth.controller;

import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author: GHW
 * @url: www.xiaohongshu.com
 * @date: 2024/10/16 17:59
 * @description: TODO
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response<String> test() {
        return Response.success("Hello, 小宏书专栏");
    }

    @GetMapping("/test2")
    @ApiOperationLog(description = "测试接口2")
    public Response<User> test2() {
        return Response.success(User.builder()
                .nickName("陈十一")
                .createTime(LocalDateTime.now())
                .build());
    }
}

