package com.wsq.jhone.service; 
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsq.jhone.ace.dao.ErrorMessageMapper;
import com.wsq.jhone.ace.model.ErrorMessage;

@Service
public class DbErrorService {
	//private final Logger logger = Logger.getLogger(this.getClass());
	private final Logger logger = Logger.getLogger(DbErrorService.class);//日志
	//注入dao
	@Autowired
	ErrorMessageMapper errorMessageMapper;
	public List<ErrorMessage> getInfo(ErrorMessage e){
		logger.info("调用mapper dao 方法");
		return 	errorMessageMapper.selectByCode(e);
	}
}
