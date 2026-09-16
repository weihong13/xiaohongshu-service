package com.guoshisan.framework.biz.context.interceptor;

import com.guoshisan.framework.biz.context.holder.LoginUserContextHolder;
import com.guoshisan.framework.common.constant.GlobalConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author: 郭拾叁
 * @date: 2026/9/14 21:25
 * @version: v1.0.0
 * @description: Feign 请求拦截器
 **/
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取当前上下文中的用户 ID
        Long userId = LoginUserContextHolder.getUserId();

        // 若不为空，则添加到请求头中
        if (Objects.nonNull(userId)) {
            requestTemplate.header(GlobalConstants.USER_ID, String.valueOf(userId));
            log.info("########## feign 请求设置请求头 userId: {}", userId);
        }
    }
}

