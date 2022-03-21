package com.ssdut.taximanage.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.entity.Logrecord;
import com.ssdut.taximanage.entity.Perinform;
import com.ssdut.taximanage.entity.Salary;
import com.ssdut.taximanage.entity.Usermanage;
import com.ssdut.taximanage.service.CarinformManage;
import com.ssdut.taximanage.service.DatetoString;
import com.ssdut.taximanage.service.InquireManage;
import com.ssdut.taximanage.service.LoginModule;
import com.ssdut.taximanage.service.Loginusermanage;
import com.ssdut.taximanage.service.PerinformManage;
import com.ssdut.taximanage.service.SalaryManage;
import com.ssdut.taximanage.service.impl.CarinformManageImpl;
import com.ssdut.taximanage.service.impl.InquireManageImpl;
import com.ssdut.taximanage.service.impl.LoginModuleImpl;
import com.ssdut.taximanage.service.impl.LoginusermanageImpl;
import com.ssdut.taximanage.service.impl.PerinformManageImpl;
import com.ssdut.taximanage.service.impl.SalaryManageImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.startTaxiManage();
	}
	
	/*
	 * 开始模块
	 */
	private static void startTaxiManage() {
		LoginModule Login = new LoginModuleImpl();
		Scanner input = new Scanner(System.in);
		Usermanage user = new Usermanage();
		System.out.println("-----------欢迎使用出租车公司管理系统-----------");
		System.out.println("选择你要执行的操作：");
		System.out.println("1,登录系统");
		System.out.println("2,注册账号");
		int type = input.nextInt();
		while(type!=1&&type!=2)
		{
			System.out.println("输入错误,请输入选择的序号");
			type = input.nextInt();
		}
		
		if(type==1) {
			user = Login.login();
			if(user!=null) {
				if(user.getLevel()<10) {
					Main.userLogin();
					}
				else {
					Main.rootLogin();
			}
			}
			else {
				System.out.println("登录失败");
			}
		}
		else {
			Login.registered();
			//登录
			user = Login.login();
			if(user!=null) {
				if(user.getLevel()<10) {
					Main.userLogin();
					}
				else {
					Main.rootLogin();
			}
			}
			else {
				System.out.println("登录失败");
			}
		}
		input.close();
	}
	
	/*
	 * 管理员登录,功能有查询登录用户状态，更改登录用户状态，查看登录记录,更新薪资表
	 */
	private static void rootLogin() {
		boolean flag = true;//退出系统条件
		int type = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("---当前状态为管理员用户,请选择你要执行的操作---");
		while(flag) {
			System.out.println("1,查询某个账号的当前状态");
			System.out.println("2,更改某个账号的当前状态");
			System.out.println("3,查询某账号的登录记录");
			System.out.println("4,更新某司机的薪资表");
			System.out.println("5,退出登录");
			System.out.println("请输入对应的序号进行操作");
			 type = input.nextInt();
			switch(type) {
			case 1:
				Main.findStatus();
				break;
			case 2:
				Main.setStatus();
				break;
			case 3:
				Main.findLoginrecord();
				break;
			case 4:
				Main.updateSalary();
				break;
			case 5:
				flag = false;
				break;
				default:
					System.out.println("输入错误,请重新操作");
					break;
			}
		}
		input.close();
	}
	
	/*
	 * 1,功能模块一，查询某账号的当前状态，传入用户名，获得用户状态
	 */
	private static void findStatus() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("输入你要查询的用户:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		String status = loginuserManage.getStatus(username);
		if(status!=null) {
			System.out.println("查询结果如下:");
			System.out.println("账户"+username+"当前状态为:"+status);
		}
		else {
			System.out.println("查询失败，不存在该用户");
		}
		//input.close();
	}
	
	/*
	 * 2,功能模块二，更改某个账号的当前状态
	 */
	private static void setStatus() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("输入你要更改信息的用户名称:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		loginuserManage.setStatus(username);
		//input.close();
	}
	
	/*
	 * 3,功能模块三，查询某账户登录记录
	 */
	private static void findLoginrecord() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("输入你要查询记录的用户名称:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		List<Logrecord> logrecordList = loginuserManage.getLogrecord(username);
		if(logrecordList!=null) {
			System.out.println(username+"的登录记录如下:");
			System.out.println("登录时间\t"+"登录IP");
			for(int i=0;i<logrecordList.size();i++) {
				System.out.println(DatetoString.datetimetoString(logrecordList.get(i).getTime())+"\t"+logrecordList.get(i).getLog_ip());
			}
		}
		//input.close();
	}
	
	/*
	 * 4，功能模块四,更新某司机的薪资表
	 */
	private static void updateSalary() {
		SalaryManage salaryManage = new SalaryManageImpl();
		System.out.println("输入你要更新的司机编号:");
		Scanner input = new Scanner(System.in);
		String id = input.nextLine().trim();
		salaryManage.updateSalary(id);
		//input.close();
	}
	
	/*
	 * 一般用户登录,只有查询权限，查询当前车辆信息，人员信息，一名司机(司机id)的上班天数和薪资情况，根据司机姓名查看开了哪几辆车，哪些天都有哪些司机上班
	 */
	private static void userLogin() {
		boolean flag = true;//退出系统条件
		Scanner input = new Scanner(System.in);
		System.out.println("---当前状态为普通用户,请选择你要执行的操作---");
		while(flag) {
			System.out.println("1,查看当前车辆信息");
			System.out.println("2,查看当前员工信息");
			System.out.println("3,查询某司机的上班天数和薪资情况");
			System.out.println("4,查询某司机开了哪几辆车");
			System.out.println("5,查询某天上班的司机");
			System.out.println("6,退出登录");
			int type = input.nextInt();
			switch(type) {
			case 1:
				Main.findCarinform();
				break;
			case 2:
				Main.findPerinform();
				break;
			case 3:
				Main.findSalary();
				break;
			case 4:
				Main.findCars();
				break;
			case 5:
				Main.findPers();
				break;
			case 6:
				flag = false;
				break;
				default:
					System.out.println("输入错误,请重新输入");
					break;
			}
		}
		input.close();
	}
	
	/*
	 * 功能模块一，查询车辆信息
	 */
	private static void findCarinform() {
		CarinformManage carinformManage = new CarinformManageImpl();
		List<Carinform> carinformList = new ArrayList<Carinform>();
		Scanner input = new Scanner(System.in);
		carinformList = carinformManage.getAllCarinform();
		if(carinformList!=null) {
			System.out.println("车辆编号\t"+"车辆部门编号");
			for(int i=0;i<carinformList.size();i++) {
				System.out.println(carinformList.get(i).getCar_id()+"\t"+carinformList.get(i).getDept_id());
			}
			System.out.println();
			System.out.println("是否继续查询某辆车的详细信息:1,继续查询 2，返回上一级菜单");
			int type = input.nextInt();
			while(type!=1&&type!=2&&!input.hasNextInt()) {
				System.out.println("输入错误，请重新输入数字1或2");
				type = input.nextInt();
				
			}
			if(type==1) {
				System.out.println("输入你要查询的车辆编号");
				String strnull = input.nextLine();
				String car_id = input.nextLine();
				System.out.println(car_id);
				Carinform carinform = carinformManage.getCarinform(car_id);
				if(carinform!=null) {
					System.out.println("车辆编号\t"+"部门编号\t"+"服役开始时间\t"+"服役结束时间");
					String datestart = DatetoString.datetoString(carinform.getOnboard_time());
					String dateend = DatetoString.datetimetoString(carinform.getResign_time());
					System.out.println(carinform.getCar_id()+"\t"+carinform.getDept_id()+"\t"+datestart+"\t"+dateend);
				}
				else {
					System.out.println("没有这辆车编号");
				}
			}
		}
		else {
			System.out.println("当前没有车辆数据，请联系管理员更新");
		}
		//input.close();
	}
	
	/*
	 * 功能模块二，查询人员信息
	 */
	private static void findPerinform() {
		PerinformManage perinformManage = new PerinformManageImpl();
		List<Perinform> perinformList = new ArrayList<Perinform>();
		Scanner input = new Scanner(System.in);
		perinformList = perinformManage.getAllPerionform();
		if(perinformList!=null) {
			System.out.println("员工编号\t"+"员工姓名");
			for(int i=0;i<perinformList.size();i++) {
				System.out.println(perinformList.get(i).getId()+"\t"+perinformList.get(i).getName());
			}
			System.out.println();
			
			System.out.println("是否继续查询某为员工的详细信息:1,继续查询 2，返回上一级菜单");
			int type = input.nextInt();
			while(type!=1&&type!=2) {
				System.out.println("输入错误，请重新输入");
				type = input.nextInt();
			}
			if(type==1) {
				System.out.println("输入你要查询的员工编号");
				String strnull = input.nextLine();
				String id = input.nextLine().trim();
				Perinform perinform = perinformManage.getPerinform(id);
				if(perinform!=null) {
					String datestart = DatetoString.datetoString(perinform.getOnboard_date());
					String dateend = DatetoString.datetoString(perinform.getResignation_date());
					System.out.println("员工编号\t"+"员工名字\t"+"部门编号\t"+"上级编号\t"+"入职时间\t"+"辞职时间\t"+"是否在职");
					StringBuffer outline = new StringBuffer(perinform.getId()+"\t");
					outline.append(perinform.getName()+"\t");
					outline.append(perinform.getDept_id()+"\t");
					outline.append(perinform.getSuper_id()+"\t");
					outline.append(datestart+"\t");
					outline.append(dateend+"\t");
					outline.append(perinform.getOnjob());
					System.out.println(outline.toString());
				}
				else {
					System.out.println("没有这个员工编号");
				}
			}
		}
		else {
			System.out.println("当前没有人员数据，请联系管理员更新");
		}
		//input.close();
	}
	
	/*
	 * 一名司机的上班天数和薪资情况
	 */
	private static void findSalary() {
			SalaryManage salaryManage = new SalaryManageImpl();
			List<Salary> salaryList = new ArrayList<Salary>();
			Scanner input = new Scanner(System.in);
			System.out.println("输入你要查询的司机编号");
			String id = input.nextLine().trim();
			salaryList = salaryManage.getSalary(id);
			if(salaryList!=null) {
				System.out.println("司机编号\t"+"年份\t"+"月份\t"+"上班天数\t"+"该月工资");
				for(int i=0;i<salaryList.size();i++) {
					int year = salaryList.get(i).getYear();
					int month = salaryList.get(i).getMonth();
					int daynum = salaryList.get(i).getDay_num();
					double wage = salaryList.get(i).getWage();
					System.out.println(id+"\t"+year+"\t"+month+"\t"+daynum+"\t"+wage);
				}
			}
			//input.close();
	}
	
	/*
	 * 根据司机姓名查看司机开了哪几辆车
	 */
	private static void findCars() {
		InquireManage inquireManage = new InquireManageImpl();
		List<Carinform> carinformList = new ArrayList<Carinform>();
		System.out.println("输入你要查询的司机姓名:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine().trim();
		carinformList = inquireManage.getCarinform(name);
		if(carinformList!=null) {
			System.out.println("司机"+name+"开过的车辆编号如下:");
			for(int i=0;i<carinformList.size();i++) {
				System.out.println(carinformList.get(i).getCar_id());
			}
		}
		//input.close();
	}
	
	/*
	 * 哪些天都有哪些司机上班
	 */
	private static void findPers() {
		InquireManage inquireManage = new InquireManageImpl();
		Date date = new Date();
		Scanner input = new Scanner(System.in);
		System.out.println("输入你要查询的日期:格式为 年-月-日");
		String strdate = input.nextLine().trim();
		date = DatetoString.stringtoDate(strdate);
		List<Perinform> perinformList = inquireManage.getPerinform(date);
		if(perinformList!=null) {
			System.out.println("当天上班的员工信息如下:");
			System.out.println("员工编号\t"+"员工姓名");
			for(int i=0;i<perinformList.size();i++) {
				System.out.println(perinformList.get(i).getId()+"\t"+perinformList.get(i).getName());
			}
		}
		else {
			System.out.println("查询错误，没有当天上班司机信息");
		}
		//input.close();
	}
}
