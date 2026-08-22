package com.guoshisan.xiaohongshu.auth.mapper;

import com.guoshisan.xiaohongshu.auth.domain.dto.UserRoleDTO;

public interface UserRoleDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleDTO record);

    int insertSelective(UserRoleDTO record);

    UserRoleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleDTO record);

    int updateByPrimaryKey(UserRoleDTO record);
}