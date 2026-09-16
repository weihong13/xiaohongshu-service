package com.guoshisan.xiaohongshu.user.biz.mapper;

import com.guoshisan.xiaohongshu.user.biz.domain.dto.UserDTO;

public interface UserDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    /**
     * 根据手机号查询记录
     * @param phone
     * @return
     */
    UserDTO selectByPhone(String phone);

    UserDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);
}