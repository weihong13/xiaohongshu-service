package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.UserRoleDTO;

public interface UserRoleDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleDTO record);

    int insertSelective(UserRoleDTO record);

    UserRoleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleDTO record);

    int updateByPrimaryKey(UserRoleDTO record);
}