package com.guoshisan.xiaohongshu.kv.biz.service;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.kv.dto.req.AddNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.req.DeleteNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.req.FindNoteContentReqDTO;
import com.guoshisan.xiaohongshu.kv.dto.resp.FindNoteContentRspDTO;

/**
 * @author: 郭拾叁
 * @date: 2026/9/17 22:06
 * @version: v1.0.0
 * @description: 笔记内容存储业务
 **/
public interface INoteContentService {

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO);

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    Response<FindNoteContentRspDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO);

    /**
     * 删除笔记内容
     *
     * @param deleteNoteContentReqDTO
     * @return
     */
    Response<?> deleteNoteContent(DeleteNoteContentReqDTO deleteNoteContentReqDTO);
}
