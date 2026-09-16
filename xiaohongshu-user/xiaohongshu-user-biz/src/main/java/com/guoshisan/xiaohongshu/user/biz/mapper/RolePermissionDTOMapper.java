package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.RolePermissionDTO;
import org.apache.ibatis.annotations.Param;

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