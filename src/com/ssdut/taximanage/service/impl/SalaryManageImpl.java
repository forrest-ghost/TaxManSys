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
		System.out.println("��ѯʧ��,�����ڸ�Ա����¼������ϵ����Ա������");
		return null;
	}

	@Override
	public void updateSalary(String id) {
		int year=0;//��ѯ�����
		int month=0;//��ѯ���·�
		int day_num=0;//���¹�������
		int workhours_num=0;//���¹�����ʱ��
		double salary_standard=80;//���¹��ʱ�׼
		double wage=0;//�����ܹ���
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ���µ����");
		year = input.nextInt();
		System.out.println("������Ҫ���µ��·�");
		month = input.nextInt();
		System.out.println("��ǰ��Ĭ�Ϲ�н��ÿСʱ80Ԫ,�Ƿ����:1,���� 2,����Ĭ��");
		int type = input.nextInt();
		while(type!=1&&type!=2)
		{
			System.out.println("�����������������!");
			type = input.nextInt();
		}
		if(type==1)
		{
			System.out.println("�����µĹ�н��׼��Ԫ/ʱ");
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
					System.out.println("����Ա��"+id+"��н�ʱ�ɹ�");
				else {
					System.out.println("����ʧ��");
				}
			}
			else
			{
				System.out.println("û�и�Ա��������Ϣ");
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
					System.out.println("����Ա��"+id+"��н�ʱ�ɹ�");
				else {
					System.out.println("����ʧ��");
				}
			}
			else
			{
				System.out.println("û�и�Ա��������Ϣ");
			}
		}
		//input.close();
	}

}
