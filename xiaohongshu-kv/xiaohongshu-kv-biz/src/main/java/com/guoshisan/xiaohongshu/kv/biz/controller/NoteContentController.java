package com.guoshisan.xiaohongshu.kv.biz.controller;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.kv.biz.service.INoteContentService;
import com.guoshisan.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.resp.FindNoteContentRspDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 郭拾叁
 * @date: 2026/9/17 21:58
 * @version: v1.0.0
 * @description: 笔记内容
 **/
@RestController
@RequestMapping("/kv")
@Slf4j
public class NoteContentController {

    @Resource
    private INoteContentService iNoteContentService;

    @PostMapping(value = "/note/content/add")
    public Response<?> addNoteContent(@Validated @RequestBody AddNoteContentReqDTO addNoteContentReqDTO) {
        return iNoteContentService.addNoteContent(addNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/find")
    public Response<FindNoteContentRspDTO> findNoteContent(@Validated @RequestBody FindNoteContentReqDTO findNoteContentReqDTO) {
        return iNoteContentService.findNoteContent(findNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/delete")
    public Response<?> deleteNoteContent(@Validated @RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO) {
        return iNoteContentService.deleteNoteContent(deleteNoteContentReqDTO);
    }

}

