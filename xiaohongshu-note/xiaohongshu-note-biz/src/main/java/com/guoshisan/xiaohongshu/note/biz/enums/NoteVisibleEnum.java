package com.guoshisan.xiaohongshu.note.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 郭拾叁
 * @url: www.guoshisan.com
 * @date: 2026-10-03 19:42
 * @description: 笔记可见性
 **/
@Getter
@AllArgsConstructor
public enum NoteVisibleEnum {

    PUBLIC(0), // 公开，所有人可见
    PRIVATE(1); // 仅自己可见

    private final Integer code;

}

