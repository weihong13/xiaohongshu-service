package com.guoshisan.framework.biz.context.config;

import com.guoshisan.framework.biz.context.interceptor.FeignRequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 21:26
 * @version: v1.0.0
 * @description: Feign 请求拦截器自动配置
 **/
@AutoConfiguration
public class FeignContextAutoConfiguration {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}

