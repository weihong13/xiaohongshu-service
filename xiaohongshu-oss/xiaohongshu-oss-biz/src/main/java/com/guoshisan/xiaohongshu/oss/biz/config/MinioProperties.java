package com.guoshisan.xiaohongshu.oss.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 郭拾叁
 * @url: www.guoshisan.com
 * @date: 2025-05-11 8:49
 * @description: TODO
 **/
@ConfigurationProperties(prefix = "storage.minio")
@Component
@Data
public class MinioProperties {
    private String endpoint;
    private String bucketName;
    private String accessKey;
    private String secretKey;
}
