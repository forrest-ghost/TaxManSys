package com.ssdut.taximanage.service;

import java.io.Console;
import com.ssdut.taximanage.entity.Usermanage;

public interface LoginModule {
	/*
	 * 用户登录
	 */
	public Usermanage login() ;
	
	/*
	 * 用户注册
	 */
	public void registered();
	
	/*
	 * 查询用户名是否重复
	 */
	public boolean getUsername(String username);
	
	/*
	 * 无显示输入密码
	 *
	 */
	 public static String inputStringNotEcho(){
			Console console = System.console();
			return new String(console.readPassword());
		}
}
