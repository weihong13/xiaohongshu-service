package com.guoshisan.xiaohongshu.user.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 郭拾叁
 * @date: 2026/9/16 22:35
 * @version: v1.0.0
 * @description: 密码更新
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserPasswordReqDTO {

    @NotBlank(message = "密码不能为空")
    private String encodePassword;

}

