package com.guoshisan.xiaohongshu.user.biz.rpc;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.oss.api.FileFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 21:06
 * @version: v1.0.0
 * @description: 对象存储服务调用
 **/
@Component
public class OssRpcService {

    @Resource
    private FileFeignApi fileFeignApi;

    public String uploadFile(MultipartFile file) {
        // 调用对象存储服务上传文件
        Response<?> response = fileFeignApi.uploadFile(file);

        if (!response.isSuccess()) {
            return null;
        }

        // 返回图片访问链接
        return (String) response.getData();
    }
}

