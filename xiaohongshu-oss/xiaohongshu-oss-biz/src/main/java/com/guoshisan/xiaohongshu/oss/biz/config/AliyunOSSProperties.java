package com.guoshisan.xiaohongshu.oss.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 郭拾叁
 * @url: www.guoshisan.com
 * @date: 2026-09-08 21:49
 * @description: 阿里云 OSS 配置项
 **/
@ConfigurationProperties(prefix = "storage.aliyun-oss")
@Component
@Data
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String accessKey;
    private String secretKey;
}

