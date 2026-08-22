package com.guoshisan.xiaohongshu.auth.mapper;

import com.guoshisan.xiaohongshu.auth.domain.dto.RolePermissionDTO;

public interface RolePermissionDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionDTO record);

    int insertSelective(RolePermissionDTO record);

    RolePermissionDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionDTO record);

    int updateByPrimaryKey(RolePermissionDTO record);
}