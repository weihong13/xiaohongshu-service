package com.guoshisan.framework.common.eumns;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 /**
 * @author: 郭拾叁
 * @url: www.xxx.com
 * @date: 2026-08-22 21:05
 * @description: 状态
 **/
@Getter
@AllArgsConstructor
public enum StatusEnum {
    // 启用
    ENABLE(0),
    // 禁用
    DISABLED(1);

    private final Integer value;
}

