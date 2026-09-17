package com.guoshisan.xiaohongshu.kv.api;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.kv.constant.ApiConstants;
import com.guoshisan.xiaohongshu.kv.dto.req.*;
import com.guoshisan.xiaohongshu.kv.dto.resp.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: 郭拾叁
 * @date: 2026/9/17 22:18
 * @version: v1.0.0
 * @description: K-V 键值存储 Feign 接口
 **/
@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRspDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);

}

