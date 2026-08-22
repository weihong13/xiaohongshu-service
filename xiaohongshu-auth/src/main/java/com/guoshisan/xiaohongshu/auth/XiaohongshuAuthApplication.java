package com.guoshisan.xiaohongshu.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.guoshisan.xiaohongshu.auth.mapper")  // 添加这行
public class XiaohongshuAuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                XiaohongshuAuthApplication.class,
                args
        );
    }

}