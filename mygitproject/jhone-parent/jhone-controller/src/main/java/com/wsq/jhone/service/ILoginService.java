package com.wsq.jhone.service;

public interface ILoginService {
	public  String checkUser(String userName,String userPass); //检查用户登录
	public  String checkLoginDateTime();//获取登录时间
	public  String setWellComeWord();//设置欢迎语 
}
