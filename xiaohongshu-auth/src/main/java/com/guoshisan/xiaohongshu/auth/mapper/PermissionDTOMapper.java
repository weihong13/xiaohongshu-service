package com.guoshisan.xiaohongshu.auth.mapper;

import com.guoshisan.xiaohongshu.auth.domain.dto.PermissionDTO;

public interface PermissionDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionDTO record);

    int insertSelective(PermissionDTO record);

    PermissionDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionDTO record);

    int updateByPrimaryKey(PermissionDTO record);
}