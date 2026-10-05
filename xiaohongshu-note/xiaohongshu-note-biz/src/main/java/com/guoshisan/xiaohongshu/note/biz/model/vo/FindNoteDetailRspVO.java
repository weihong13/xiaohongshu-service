package com.guoshisan.xiaohongshu.note.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: 郭拾叁
 * @date: 2026/10/05 13:03
 * @version: v1.0.0
 * @description: 查询笔记详情
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteDetailRspVO {

    private Long id;

    private Integer type;

    private String title;

    private String content;

    private List<String> imgUris;

    private Long topicId;

    private String topicName;

    private Long creatorId;

    private String creatorName;

    private String avatar;

    private String videoUri;

    /**
     * 编辑时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否可见
     */
    private Integer visible;

}

