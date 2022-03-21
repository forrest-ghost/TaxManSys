package com.ssdut.taximanage.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.dao.UsermanageDao;
import com.ssdut.taximanage.dao.impl.UsermanageDaoImpl;
import com.ssdut.taximanage.entity.Usermanage;
import com.ssdut.taximanage.service.Ipconfig;
import com.ssdut.taximanage.service.LoginModule;
import com.ssdut.taximanage.service.MD5Utils;

public class LoginModuleImpl implements LoginModule {

	@Override
	public Usermanage login() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String datenow = dateTime.format(formatter);
		
		Scanner input = new Scanner(System.in);
		// 1、输入账户名称
		System.out.println("请先登录，请您输入账户名称：");
		String userName = input.nextLine().trim();
		System.out.println("请您输入密码：");
		String userPassword = input.nextLine().trim();
		UsermanageDao userDao = new UsermanageDaoImpl();
		String sql = "select * from Usermanage where user=? and passwd=?";
		String sql1 = "INSERT INTO Logrecord values(?,?,?,?)";
		String[] param = { MD5Utils.code(userName), MD5Utils.code(userPassword) };
		
		String[] param1 = { MD5Utils.code(userName), MD5Utils.code(userPassword),datenow,Ipconfig.getIP() };
		
		Usermanage owner = userDao.selectUsermanage(sql, param);
		userDao.updateUsermanage(sql1, param1);
		//input.close();
		if (owner.getUser() != null) {
			String status = owner.getStatus();
			if("alive".equals(status))
			{
				System.out.println("-------恭喜您成功登录-------");
				System.out.println("-------您的基本信息：-------");
				System.out.println("账户名：" + userName);
				System.out.println("账户状态：" + owner.getStatus());
				if(owner.getLevel()<10)
				{
					System.out.println("账户权限：" + "一般用户");
				}
				else
				{
					System.out.println("账户权限：" + "管理员账户");
				}
				return owner;
			}
			else
			{
				System.out.println("你的账户存在异常,请联系管理员解决！");
				return null;
			}
			
		}
		else {
			System.out.println("没有该账号，请重新输入账号或注册一个账号！！！");
			return null;
		}
		
	}

	@Override
	public void registered() {
		UsermanageDao userDao = new UsermanageDaoImpl();
		List<Usermanage> userlist = userDao.getAllUsermanage();
		String userName="小明";
		String userPassword="123";
		Scanner input = new Scanner(System.in);
		boolean flag=true;
		if(userlist != null)
		{
			// 1、输入账户名称
			while(flag)
			{
				System.out.println("请您输入账户名称：");
				userName = input.nextLine().trim();
				while(!this.getUsername(userName))
				{
					System.out.println("账户名重复，请重新输入");
					userName = input.nextLine().trim();
				}
				System.out.println("请您输入密码：");
				userPassword = input.nextLine().trim();
				System.out.println("请您再次输入密码：");
				String userPassword1 = input.nextLine().trim();
				if(!userPassword.equals(userPassword1))
				{
					System.out.println("两次密码不同，请重新输入！！！");
				}
				else
				{
					System.out.println("账户注册成功！");
					flag =false;
				}
			}
			String sql = "INSERT INTO Usermanage(user,passwd,status,level) values(?,?,'alive',1)";
			String[] param = { MD5Utils.code(userName), MD5Utils.code(userPassword) };
			userDao.updateUsermanage(sql, param);
		}
		else
		{
			System.out.println("该系统目前还没有用户，你将成为该系统的管理员！");
			System.out.println("是否继续注册：Yes or No!");
			String type = input.nextLine().trim();
			while(!"Yes".equals(type)&&!"No".equals(type))
			{
				System.out.println("输入错误，请输入Yes或者No");
				type = input.nextLine().trim();
			}
			if("No".equals(type))
			{
				flag =false;
			}
			// 1、输入账户名称
						while(flag)
						{
							System.out.println("请您输入账户名称：");
							userName = input.nextLine().trim();
							while(!this.getUsername(userName))
							{
								System.out.println("账户名重复，请重新输入");
								userName = input.nextLine().trim();
							}
							System.out.println("请您输入密码：");
							userPassword = input.nextLine().trim();
							System.out.println("请您再次输入密码：");
							String userPassword1 = input.nextLine().trim();
							if(!userPassword.equals(userPassword1))
							{
								System.out.println("两次密码不同，请重新输入！！！");
							}
							else
							{
								System.out.println("账户注册成功！");
								flag =false;
							}
						}
						String sql = "INSERT INTO Usermanage(user,passwd,status,level) values(?,?,'alive',10)";
						String[] param = { MD5Utils.code(userName), MD5Utils.code(userPassword) };
						userDao.updateUsermanage(sql, param);
		}
		
		//input.close();
	}
	
	public boolean getUsername(String username) {
		UsermanageDao userDao = new UsermanageDaoImpl();
		String sql = "select * from Usermanage where user=?";
		String[] param = { MD5Utils.code(username) };
		Usermanage owner = userDao.selectUsermanage(sql, param);
		if(owner==null)
			return true;//账户名称不重复
		else
			return false;//账户名称重复
	}
}
