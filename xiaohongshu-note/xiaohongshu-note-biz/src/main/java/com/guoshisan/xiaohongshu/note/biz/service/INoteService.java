package com.guoshisan.xiaohongshu.note.biz.service;


import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.note.biz.model.vo.FindNoteDetailReqVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.FindNoteDetailRspVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.PublishNoteReqVO;
import com.guoshisan.xiaohongshu.note.biz.model.vo.UpdateNoteReqVO;

/**
 * @author: 郭拾叁
 * @date: 2026/10/03 20:50
 * @version: v1.0.0
 * @description: 笔记业务
 **/
public interface INoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Response<?> publishNote(PublishNoteReqVO publishNoteReqVO);

    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Response<FindNoteDetailRspVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO);

    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Response<?> updateNote(UpdateNoteReqVO updateNoteReqVO);
}
