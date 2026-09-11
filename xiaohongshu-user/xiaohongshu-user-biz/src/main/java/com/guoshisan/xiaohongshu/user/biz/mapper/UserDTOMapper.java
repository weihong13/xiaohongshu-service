package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.UserDTO;

public interface UserDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}