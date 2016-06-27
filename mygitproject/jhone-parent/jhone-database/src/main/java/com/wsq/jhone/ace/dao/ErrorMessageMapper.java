package com.wsq.jhone.ace.dao;

import java.util.List;

import com.wsq.jhone.ace.model.ErrorMessage;

public interface ErrorMessageMapper {
    int deleteByPrimaryKey(String errcode);

    int insert(ErrorMessage record);

    int insertSelective(ErrorMessage record);

    ErrorMessage selectByPrimaryKey(String errcode);

    int updateByPrimaryKeySelective(ErrorMessage record);

    int updateByPrimaryKey(ErrorMessage record);
    
    List<ErrorMessage> selectByCode(ErrorMessage record);
}