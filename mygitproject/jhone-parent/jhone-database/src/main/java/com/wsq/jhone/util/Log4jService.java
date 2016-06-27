package com.wsq.jhone.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Log4jService implements ServletContextListener {
    public static final String log4jdirkey = "log4j.xml";
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		 

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
