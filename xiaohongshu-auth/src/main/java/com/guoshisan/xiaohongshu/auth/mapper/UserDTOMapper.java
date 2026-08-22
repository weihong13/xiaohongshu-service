package com.guoshisan.xiaohongshu.auth.mapper;

import com.guoshisan.xiaohongshu.auth.domain.dto.UserDTO;

public interface UserDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Long id);

    /**
     * 根据手机号查询记录
     * @param phone
     * @return
     */
    UserDTO selectByPhone(String phone);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}