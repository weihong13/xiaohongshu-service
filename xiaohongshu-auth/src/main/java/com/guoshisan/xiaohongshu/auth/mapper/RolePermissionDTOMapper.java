package com.guoshisan.xiaohongshu.auth.mapper;

import com.guoshisan.xiaohongshu.auth.domain.dto.RolePermissionDTO;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface RolePermissionDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermissionDTO record);

    int insertSelective(RolePermissionDTO record);

    RolePermissionDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermissionDTO record);

    int updateByPrimaryKey(RolePermissionDTO record);

    /**
     * 根据角色 ID 集合批量查询
     *
     * @param roleIds
     * @return
     */
    List<RolePermissionDTO> selectByRoleIds(@Param("roleIds") List<Long> roleIds);
}