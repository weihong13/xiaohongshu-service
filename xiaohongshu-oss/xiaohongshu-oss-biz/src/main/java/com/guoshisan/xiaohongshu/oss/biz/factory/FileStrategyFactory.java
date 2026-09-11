package com.guoshisan.xiaohongshu.oss.biz.factory;

import com.guoshisan.xiaohongshu.oss.biz.strategy.FileStrategy;
import com.guoshisan.xiaohongshu.oss.biz.strategy.impl.AliyunOSSFileStrategy;
import com.guoshisan.xiaohongshu.oss.biz.strategy.impl.MinioFileStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 郭宏伟
 * @date: 2026/9/6 23:20
 * @version: v1.0.0
 * @description: TODO
 **/
@Configuration
@RefreshScope
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @Bean
    @RefreshScope
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }

        throw new IllegalArgumentException("不可用的存储类型");
    }

}

