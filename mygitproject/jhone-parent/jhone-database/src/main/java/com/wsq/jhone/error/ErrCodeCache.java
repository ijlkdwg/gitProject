package com.wsq.jhone.error;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository; 
import com.wsq.jhone.ace.model.ErrorMessage; 
import com.wsq.jhone.service.DbErrorService;
import com.wsq.jhone.util.ApplicationContextHelper;
@Repository
public class ErrCodeCache implements ApplicationListener<ApplicationEvent> { 
	 private static boolean _isFirst = true;//定义静态变量
	 private static final Logger logger = Logger.getLogger(ApplicationContextHelper.class);
	 private static HashMap<String, ErrorMessage> _errCodes = new HashMap<String, ErrorMessage>();//静态的hashMap 存放数据
	 public static String getErrDesc(String errCode) {
		 ErrorMessage errorBean = (ErrorMessage)_errCodes.get(errCode);
		    if (errorBean == null) {
		      return "";
		    }
		    return errorBean.getErrdesc();
		  }
	public static String getErrSolution(String errCode){
		 ErrorMessage errorBean = (ErrorMessage)_errCodes.get(errCode);
		 if (errorBean == null) {
		      return "";
		   }
		 return errorBean.getErrsolution();
		 
	}
	//绑定 事件
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		  if (!_isFirst) return;
		    _isFirst = false;
		    load();  
	}
	  public static void load() {
		    load(null);
		  }
	 
	  public static void load(String errCode) {
		  ErrorMessage error = new ErrorMessage();
		  error.setErrcode(errCode);
		  List<ErrorMessage>  list = getListInfo(error); 
		  logger.info("返回的数据为【"+list+"】");
		  if(list.isEmpty() || list.size()<=0){
			 return;
		  }else{
			  error.setErrcode(list.get(0).getErrcode());
			  error.setErrdesc(list.get(0).getErrdesc());
			  error.setErrsolution(list.get(0).getErrsolution());
			  _errCodes.put(error.getErrcode(), error);
		  }
	  }
	  public static List<ErrorMessage> getListInfo(ErrorMessage e){
		  DbErrorService dbService = (DbErrorService) ApplicationContextHelper.getBean("dbErrorService");
		  logger.debug("获取到的对象bean工厂是"+dbService);
		  return dbService.getInfo(e);
	  }
	 
}
