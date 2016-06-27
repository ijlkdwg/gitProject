package com.wsq.jhone.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class LoginOutController {
	//用户退出 清除session包括shiro session
	@RequestMapping("/logout")
	public String loginOut(HttpServletRequest request){
		 SecurityUtils.getSubject().logout();
		 return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/"; 
	}  
}
