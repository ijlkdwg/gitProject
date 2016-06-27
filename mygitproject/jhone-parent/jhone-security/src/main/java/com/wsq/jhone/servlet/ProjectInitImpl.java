package com.wsq.jhone.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;
 
 
@Repository
public class ProjectInitImpl implements ApplicationListener<ApplicationEvent> {
	  private static boolean _isFirst=true;//是否第一次加载 
	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
			System.out.println("我想知道这个arg0是干什么的======"+arg0.getSource().getClass().getName());			
		   if(!_isFirst) return;
	        _isFirst=false;
	        load();
	}
	public static void load(){
		System.out.println("我是启动的时候就要加载的哈要看清楚，只加载一次的------------");
	}
}
