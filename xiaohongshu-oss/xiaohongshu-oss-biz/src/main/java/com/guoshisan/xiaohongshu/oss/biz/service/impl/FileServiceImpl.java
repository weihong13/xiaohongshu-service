package com.guoshisan.xiaohongshu.oss.biz.service.impl;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.oss.biz.service.FileService;
import com.guoshisan.xiaohongshu.oss.biz.strategy.FileStrategy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 郭宏伟
 * @date: 2026/9/6 23:20
 * @version: v1.0.0
 * @description: TODO
 **/
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url = fileStrategy.uploadFile(file);

        return Response.success(url);
    }
}

