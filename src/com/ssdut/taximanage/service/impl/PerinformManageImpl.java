package com.ssdut.taximanage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.dao.PerinformDao;
import com.ssdut.taximanage.dao.impl.PerinformDaoImpl;
import com.ssdut.taximanage.entity.Perinform;
import com.ssdut.taximanage.service.PerinformManage;

public class PerinformManageImpl implements PerinformManage {

	@Override
	public List<Perinform> getAllPerionform() {
		PerinformDao perinformDao =new PerinformDaoImpl();
		List<Perinform> perinformList = new ArrayList<Perinform>();
		perinformList = perinformDao.getAllPerinform();
		return perinformList;
	}

	@Override
	public Perinform getPerinform(String id) {
		Perinform perinform =new Perinform();
		PerinformDao perinformDao =new PerinformDaoImpl();
		String sql = "select * from Perinform where id=?";
		String[] param = {id};
		perinform = perinformDao.selectPerinform(sql,param);
			return perinform;
	}

	@Override
	public void setPerinform(String id) {
		Perinform perinform =new Perinform();
		PerinformDao perinformDao =new PerinformDaoImpl();
		String sql = "select * from Perinform where id=?";
		String[] param = {id};
		perinform = perinformDao.selectPerinform(sql,param);
		if(perinform!=null)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("请选择你要更改的属性,输入对应序号即可：");
			System.out.println("1,员工名字 2，部门编号 3，上级编号 4，入职时间 5，辞职时间 6，是否在职");
			int flag = input.nextInt();
			int sign = 0;
			while(flag<1&&flag>6&&!input.hasNextInt())
			{
				System.out.println("输入不合法,请重新输入：");
				flag = input.nextInt();
			}
			switch(flag)
			{
			case 1:
				String sql1 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工名字:");
				String name=input.nextLine().trim();
				String[] param1 = {name,id};
				sign = perinformDao.updatePerinform(sql1, param1);
				break;
			case 2:
				String sql2 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工部门编号:");
				String dept_id=input.nextLine().trim();
				String[] param2 = {dept_id,id};
				sign = perinformDao.updatePerinform(sql2, param2);
				break;
			case 3:
				String sql3 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工上级编号:");
				String super_id=input.nextLine().trim();
				String[] param3 = {super_id,id};
				sign = perinformDao.updatePerinform(sql3, param3);
				break;
			case 4:
				String sql4 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工入职时间:");
				System.out.println("时间格式为：年-月-日");
				String onboard_date=input.nextLine().trim();
				String[] param4 = {onboard_date,id};
				sign = perinformDao.updatePerinform(sql4, param4);
				break;
			case 5:
				String sql5 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工辞职时间:");
				String resignation_date=input.nextLine().trim();
				String[] param5 = {resignation_date,id};
				sign = perinformDao.updatePerinform(sql5, param5);
				break;
			case 6:
				String sql6 = "update Perinform set name=? where id=?";
				System.out.println("请输入更改后的员工在职状态:");
				System.out.println("Yes表示在职，No表示离职！");
				String onjob=input.nextLine().trim();
				while(!onjob.equals("Yes")&&!onjob.equals("No"))
				{
					System.out.print("输入不合法,请重新输入:");
					onjob=input.nextLine().trim();
				}
				String[] param6 = {onjob,id};
				sign = perinformDao.updatePerinform(sql6, param6);
				break;
			}
			if(sign>0)
				System.out.println("更新员工信息成功！");
			else
				System.out.println("更新员工信息失败！");
			//input.close();
		}
		else
		{
			System.out.println("没有这个员工!");
		}

	}

	@Override
	public void addPerinform(String id) {
		Perinform perinform =new Perinform();
		PerinformDao perinformDao =new PerinformDaoImpl();
		String sql = "selet * from Perinform where id=?";
		String[] param = {id};
		perinform = perinformDao.selectPerinform(sql,param);
		if(perinform!=null)
		{
			System.out.println("该员工编号已存在,请更改编号后重试!");
		}
		else {
			Scanner input = new Scanner(System.in);
			String sql1 = "insert into Perinform(id,name,dept_id,super_id,onboard_date,resignation_date,onjob) values(?,?,?,?,?,?,?)";
			System.out.println("请输入员工名字:");
			String name = input.nextLine().trim();
			System.out.println("请输入部门编号:");
			String dept_id = input.nextLine().trim();
			System.out.println("请输入上级编号:");
			String super_id = input.nextLine().trim();
			System.out.println("请输入员工入职时间:格式为 年-月-日");
			String onboard_date = input.nextLine().trim();
			System.out.println("请输入员工离职时间:格式为 年-月-日");
			String resignation_date = input.nextLine().trim();
			System.out.println("请输入员工在职状态:Yes or No");
			String onjob = input.nextLine().trim();
			while(!onjob.equals("Yes")&&!onjob.equals("No"))
			{
				System.out.print("输入不合法,请重新输入:");
				onjob=input.nextLine().trim();
			}
			String[] param1 = {id,name,dept_id,super_id,onboard_date,resignation_date,onjob};
			int sign = perinformDao.updatePerinform(sql1, param1);
			if(sign>0)
				System.out.println("增加员工成功!");
			else
				System.out.println("增加员工信息失败!");
			//input.close();
		}
			

	}

}
