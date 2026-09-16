package com.guoshisan.xiaohongshu.oss.api;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.oss.config.FeignFormConfig;
import com.guoshisan.xiaohongshu.oss.constant.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 20:36
 * @version: v1.0.0
 * @description: TODO
 **/
@FeignClient(name = ApiConstants.SERVICE_NAME, configuration = FeignFormConfig.class)
public interface FileFeignApi {

    String PREFIX = "/file";

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping(value = PREFIX + "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response<?> uploadFile(@RequestPart(value = "file") MultipartFile file);

}
