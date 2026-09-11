package com.guoshisan.xiaohongshu.oss.biz.strategy;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 郭宏伟
 * @date: 2026/9/6 23:20
 * @version: v1.0.0
 * @description: 文件策略接口
 **/
public interface FileStrategy {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);

}

