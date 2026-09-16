package com.guoshisan.xiaohongshu.oss.biz.controller;

import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 20:34
 * @version: v1.0.0
 * @description: Feign 测试接口
 **/
@RestController
@RequestMapping("/file")
@Slf4j
public class TestFeignController {

    @PostMapping(value = "/test")
    @ApiOperationLog(description = "Feign 测试接口")
    public Response<?> test() {
        return Response.success();
    }

}
