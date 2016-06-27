package com.wsq.jhone.ace.dao;

import com.wsq.jhone.ace.model.UserBean;

public interface UserBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);
}