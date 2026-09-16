package com.guoshisan.xiaohongshu.user.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.guoshisan.xiaohongshu.user.biz.mapper")
@EnableFeignClients(basePackages = "com.guoshisan.xiaohongshu")
public class XiaohongshuUserBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }

}
