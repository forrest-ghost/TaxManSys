package com.ssdut.taximanage.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.dao.AttendanceDao;
import com.ssdut.taximanage.dao.SalaryDao;
import com.ssdut.taximanage.dao.impl.AttendanceDaoImpl;
import com.ssdut.taximanage.dao.impl.SalaryDaoImpl;
import com.ssdut.taximanage.entity.Attendance;
import com.ssdut.taximanage.entity.Salary;
import com.ssdut.taximanage.service.SalaryManage;

public class SalaryManageImpl implements SalaryManage {

	@Override
	public List<Salary> getSalary(String id) {
		SalaryDao salaryDao = new SalaryDaoImpl();
		List<Salary> salaryList = new ArrayList<Salary>();
		String sql = "select * from Salary where id=?";
		String[] param = {id};
		salaryList = salaryDao.selectSalary(sql, param);
		if(salaryList!=null)
		{
			return salaryList;
		}
		System.out.println("查询失败,不存在该员工记录，请联系管理员检查更新");
		return null;
	}

	@Override
	public void updateSalary(String id) {
		int year=0;//查询的年份
		int month=0;//查询的月份
		int day_num=0;//该月工作天数
		int workhours_num=0;//该月工作总时长
		double salary_standard=80;//该月工资标准
		double wage=0;//该月总工资
		Scanner input = new Scanner(System.in);
		System.out.println("输入你要更新的年份");
		year = input.nextInt();
		System.out.println("输入你要更新的月份");
		month = input.nextInt();
		System.out.println("当前的默认工薪是每小时80元,是否更改:1,更改 2,保存默认");
		int type = input.nextInt();
		while(type!=1&&type!=2)
		{
			System.out.println("输入错误，请重新输入!");
			type = input.nextInt();
		}
		if(type==1)
		{
			System.out.println("输入新的工薪标准：元/时");
			salary_standard = input.nextDouble();
		}
		
		
		SalaryDao salaryDao = new SalaryDaoImpl();
		List<Salary> salaryList = new ArrayList<Salary>();
		String sql = "select * from Salary where id=? and year=? and month=?";
		Object[] param = {id,year,month};
		salaryList = salaryDao.selectSalary(sql, param);
		if(salaryList!=null)
		{
			AttendanceDao attendanceDao = new AttendanceDaoImpl();
			List<Attendance> attendanceList = new ArrayList<Attendance>();
			String sql1 = "select * from Attendance where id=?";
			String[] param1 = {id};
			attendanceList = attendanceDao.selectAttendance(sql1, param1);
			if(attendanceList!=null)
			{
				for(int i=0;i<attendanceList.size();i++)
				{
					Date date = attendanceList.get(i).getDate();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					
					int year1 = calendar.get(Calendar.YEAR);
					int month1 = calendar.get(Calendar.MONTH)+1;
					
					if(year==year1&&month==month1)
					{
						day_num++;
						workhours_num+=attendanceList.get(i).getWorkhours();
					}
				}
				wage = salary_standard * workhours_num;
				String sql2 = "update Salary set day_num=?,salary_standard=?,wage=? where id=? and year=? and month=?";
				Object[] param2 = {day_num,salary_standard,wage,id,year,month};
				int flag = salaryDao.updateSalary(sql2, param2);
				if(flag>0)
					System.out.println("更新员工"+id+"的薪资表成功");
				else {
					System.out.println("更新失败");
				}
			}
			else
			{
				System.out.println("没有该员工出勤信息");
			}
		}
		else
		{
			AttendanceDao attendanceDao = new AttendanceDaoImpl();
			List<Attendance> attendanceList = new ArrayList<Attendance>();
			String sql1 = "select * from Attendance where id=?";
			String[] param1 = {id};
			attendanceList = attendanceDao.selectAttendance(sql1, param1);
			if(attendanceList!=null)
			{
				for(int i=0;i<attendanceList.size();i++)
				{
					Date date = attendanceList.get(i).getDate();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					
					int year1 = calendar.get(Calendar.YEAR);
					int month1 = calendar.get(Calendar.MONTH);
					
					if(year==year1&&month==month1)
					{
						day_num++;
						workhours_num+=attendanceList.get(i).getWorkhours();
					}
				}
				wage = salary_standard * workhours_num;
				String sql2 = "insert into Salary (id,year,month,day_num,salary_standard,wage) values(?,?,?,?,?,?)";
				Object[] param2 = {id,year,month,day_num,salary_standard,wage};
				int flag = salaryDao.updateSalary(sql2, param2);
				if(flag>0)
					System.out.println("更新员工"+id+"的薪资表成功");
				else {
					System.out.println("更新失败");
				}
			}
			else
			{
				System.out.println("没有该员工出勤信息");
			}
		}
		//input.close();
	}

}
