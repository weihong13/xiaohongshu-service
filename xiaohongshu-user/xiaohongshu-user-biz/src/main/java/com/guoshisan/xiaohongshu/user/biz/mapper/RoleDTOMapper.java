package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.RoleDTO;

import java.util.List;

public interface RoleDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDTO record);

    int insertSelective(RoleDTO record);

    RoleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDTO record);

    int updateByPrimaryKey(RoleDTO record);

    /**
     * 查询所有被启用的角色
     *
     * @return
     */
    List<RoleDTO> selectEnabledList();
}