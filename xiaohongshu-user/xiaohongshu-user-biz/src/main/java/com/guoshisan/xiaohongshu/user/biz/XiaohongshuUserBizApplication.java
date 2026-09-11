package com.guoshisan.xiaohongshu.user.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.guoshisan.xiaohongshu.user.biz.mapper")
public class XiaohongshuUserBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohongshuUserBizApplication.class, args);
    }

}
