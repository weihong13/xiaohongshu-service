package com.xiaohongshu.xiaohongshu.auth.controller;

import com.xiaohongshu.framework.common.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GHW
 * @url: www.xiaohongshu.com
 * @date: 2024/10/16 17:59
 * @description: TODO
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public Response<String> test() {
        return Response.success("Hello, 小宏书专栏");
    }
}

