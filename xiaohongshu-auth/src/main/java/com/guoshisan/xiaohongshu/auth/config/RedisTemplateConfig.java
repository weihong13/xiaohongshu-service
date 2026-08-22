package com.guoshisan.xiaohongshu.auth.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 郭拾叁
 * @date: 2026/8/22 15:51
 * @version: v1.0.0
 * @description: RedisTemplate 配置
 **/
@Configuration
public class RedisTemplateConfig {

    @Bean
    public CommandLineRunner autoConfigDebug(
            org.springframework.core.env.Environment environment) {

        return args -> {
            System.out.println("==============================");
            System.out.println(
                    "Spring Boot Version: " +
                            org.springframework.boot.SpringBootVersion.getVersion()
            );
            System.out.println("==============================");
        };
    }
}
