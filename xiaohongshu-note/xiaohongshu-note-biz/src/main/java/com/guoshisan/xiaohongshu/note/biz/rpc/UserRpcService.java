package com.guoshisan.xiaohongshu.note.biz.rpc;

import com.guoshisan.framework.common.response.Response;
import com.guoshisan.xiaohongshu.user.api.UserFeignApi;
import com.guoshisan.xiaohongshu.user.dto.req.FindUserByIdReqDTO;
import com.guoshisan.xiaohongshu.user.dto.resp.FindUserByIdRspDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: 郭拾叁
 * @date: 2026/10/05 13:10
 * @version: v1.0.0
 * @description: 用户服务
 **/
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public FindUserByIdRspDTO findById(Long userId) {
        FindUserByIdReqDTO findUserByIdReqDTO = new FindUserByIdReqDTO();
        findUserByIdReqDTO.setId(userId);

        Response<FindUserByIdRspDTO> response = userFeignApi.findById(findUserByIdReqDTO);

        if (Objects.isNull(response) || !response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

}

