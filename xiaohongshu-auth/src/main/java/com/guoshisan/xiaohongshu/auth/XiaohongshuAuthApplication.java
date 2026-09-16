package com.guoshisan.xiaohongshu.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.guoshisan.xiaohongshu")
public class XiaohongshuAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuAuthApplication.class, args);
    }
}
