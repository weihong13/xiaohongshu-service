package com.guoshisan.xiaohongshu.note.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.guoshisan.xiaohongshu.note.biz.mapper")
@EnableFeignClients(basePackages = "com.guoshisan.xiaohongshu")
public class XiaohongshuNoteBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuNoteBizApplication.class, args);
    }

}
