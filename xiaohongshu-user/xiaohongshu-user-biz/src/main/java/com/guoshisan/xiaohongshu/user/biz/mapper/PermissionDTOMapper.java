package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.PermissionDTO;

import java.util.List;

public interface PermissionDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionDTO record);

    int insertSelective(PermissionDTO record);

    PermissionDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionDTO record);

    int updateByPrimaryKey(PermissionDTO record);

    /**
     * 查询 APP 端所有被启用的权限
     *
     * @return
     */
    List<PermissionDTO> selectAppEnabledList();
}