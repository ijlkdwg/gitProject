package com.wsq.jhone.ace.dao;

import com.wsq.jhone.ace.model.UserRoleBean;

public interface UserRoleBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleBean record);

    int insertSelective(UserRoleBean record);

    UserRoleBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleBean record);

    int updateByPrimaryKey(UserRoleBean record);
}