package com.guoshisan.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 郭拾叁
 * @url: www.guoshisan.com
 * @date: 2026-08-22 21:05
 * @description: 逻辑删除
 **/
@Getter
@AllArgsConstructor
public enum DeletedEnum {

    YES(true),
    NO(false);

    private final Boolean value;
}
