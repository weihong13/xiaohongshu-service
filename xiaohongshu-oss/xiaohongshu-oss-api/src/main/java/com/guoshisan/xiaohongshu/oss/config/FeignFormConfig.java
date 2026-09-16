package com.guoshisan.xiaohongshu.oss.config;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 21:00
 * @version: v1.0.0
 * @description: TODO
 **/
@Configuration
public class FeignFormConfig {

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}

