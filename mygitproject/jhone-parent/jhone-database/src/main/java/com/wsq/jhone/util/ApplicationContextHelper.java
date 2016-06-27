package com.wsq.jhone.util;
import org.apache.log4j.Logger;
/**
 * 工具类使用它可以调用spring ioc 里面的bean 
 * 调用方法也很简单就是类名但首字母小写就行了
 * @author 温顺全
 * @version 1.0
 * @data 2016-06-08
 */
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class ApplicationContextHelper implements ApplicationContextAware {
	private static ApplicationContext appCtx;
	private static final Logger logger = Logger.getLogger(ApplicationContextHelper.class);
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		appCtx = arg0; 
	}
	 public static ApplicationContext getApplicationContext()
	  {
	    return appCtx;
	  } 
	  public static Object getBean(String beanName)
	  {
	    try
	    {
	      logger.info("开始获取spring ioc bean 对应的类"+beanName); 
	      logger.debug("开始获取spring ioc bean 对应的类"+beanName); 
	      return appCtx.getBean(beanName); 
	    } 
	    	catch (BeansException e) {
	    }
	    return null;
	  }

	  public static String getBeanId(Class<?> type)
	  {
		  return appCtx.getBeanNamesForType(type)[0];
	  }
}
