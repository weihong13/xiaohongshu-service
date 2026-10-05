package com.guoshisan.xiaohongshu.note.biz.controller;

import com.guoshisan.framework.biz.operationlog.aspect.ApiOperationLog;
import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.note.biz.model.vo.FindNoteDetailReqVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.FindNoteDetailRspVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.UpdateNoteReqVO;
import com.guoshisan.xiaohongshu.note.biz.service.INoteService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 郭拾叁
 * @date: 2026/10/03 20:41
 * @version: v1.0.0
 * @description: 笔记
 **/
@RestController
@RequestMapping("/note")
@Slf4j
public class NoteController {

    @Resource
    private INoteService iNoteService;

    @PostMapping(value = "/publish")
    @ApiOperationLog(description = "笔记发布")
    public Response<?> publishNote(@Validated @RequestBody PublishNoteReqVO publishNoteReqVO) {
        return iNoteService.publishNote(publishNoteReqVO);
    }

    @PostMapping(value = "/detail")
    @ApiOperationLog(description = "笔记详情")
    public Response<FindNoteDetailRspVO> findNoteDetail(@Validated @RequestBody FindNoteDetailReqVO findNoteDetailReqVO) {
        return iNoteService.findNoteDetail(findNoteDetailReqVO);
    }

    @PostMapping(value = "/update")
    @ApiOperationLog(description = "笔记修改")
    public Response<?> updateNote(@Validated @RequestBody UpdateNoteReqVO updateNoteReqVO) {
        return iNoteService.updateNote(updateNoteReqVO);
    }

}
