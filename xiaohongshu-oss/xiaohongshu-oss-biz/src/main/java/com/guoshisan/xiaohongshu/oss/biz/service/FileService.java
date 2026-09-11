package com.guoshisan.xiaohongshu.oss.biz.service;

import com.guoshisan.framework.common.response.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 郭宏伟
 * @date: 2026/9/6 23:20
 * @version: v1.0.0
 * @description: TODO
 **/
public interface FileService {

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    Response<?> uploadFile(MultipartFile file);
}

