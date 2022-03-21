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
			System.out.println("��ѡ����Ҫ���ĵ�����,�����Ӧ��ż��ɣ�");
			System.out.println("1,Ա������ 2�����ű�� 3���ϼ���� 4����ְʱ�� 5����ְʱ�� 6���Ƿ���ְ");
			int flag = input.nextInt();
			int sign = 0;
			while(flag<1&&flag>6&&!input.hasNextInt())
			{
				System.out.println("���벻�Ϸ�,���������룺");
				flag = input.nextInt();
			}
			switch(flag)
			{
			case 1:
				String sql1 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա������:");
				String name=input.nextLine().trim();
				String[] param1 = {name,id};
				sign = perinformDao.updatePerinform(sql1, param1);
				break;
			case 2:
				String sql2 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա�����ű��:");
				String dept_id=input.nextLine().trim();
				String[] param2 = {dept_id,id};
				sign = perinformDao.updatePerinform(sql2, param2);
				break;
			case 3:
				String sql3 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա���ϼ����:");
				String super_id=input.nextLine().trim();
				String[] param3 = {super_id,id};
				sign = perinformDao.updatePerinform(sql3, param3);
				break;
			case 4:
				String sql4 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա����ְʱ��:");
				System.out.println("ʱ���ʽΪ����-��-��");
				String onboard_date=input.nextLine().trim();
				String[] param4 = {onboard_date,id};
				sign = perinformDao.updatePerinform(sql4, param4);
				break;
			case 5:
				String sql5 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա����ְʱ��:");
				String resignation_date=input.nextLine().trim();
				String[] param5 = {resignation_date,id};
				sign = perinformDao.updatePerinform(sql5, param5);
				break;
			case 6:
				String sql6 = "update Perinform set name=? where id=?";
				System.out.println("��������ĺ��Ա����ְ״̬:");
				System.out.println("Yes��ʾ��ְ��No��ʾ��ְ��");
				String onjob=input.nextLine().trim();
				while(!onjob.equals("Yes")&&!onjob.equals("No"))
				{
					System.out.print("���벻�Ϸ�,����������:");
					onjob=input.nextLine().trim();
				}
				String[] param6 = {onjob,id};
				sign = perinformDao.updatePerinform(sql6, param6);
				break;
			}
			if(sign>0)
				System.out.println("����Ա����Ϣ�ɹ���");
			else
				System.out.println("����Ա����Ϣʧ�ܣ�");
			//input.close();
		}
		else
		{
			System.out.println("û�����Ա��!");
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
			System.out.println("��Ա������Ѵ���,����ı�ź�����!");
		}
		else {
			Scanner input = new Scanner(System.in);
			String sql1 = "insert into Perinform(id,name,dept_id,super_id,onboard_date,resignation_date,onjob) values(?,?,?,?,?,?,?)";
			System.out.println("������Ա������:");
			String name = input.nextLine().trim();
			System.out.println("�����벿�ű��:");
			String dept_id = input.nextLine().trim();
			System.out.println("�������ϼ����:");
			String super_id = input.nextLine().trim();
			System.out.println("������Ա����ְʱ��:��ʽΪ ��-��-��");
			String onboard_date = input.nextLine().trim();
			System.out.println("������Ա����ְʱ��:��ʽΪ ��-��-��");
			String resignation_date = input.nextLine().trim();
			System.out.println("������Ա����ְ״̬:Yes or No");
			String onjob = input.nextLine().trim();
			while(!onjob.equals("Yes")&&!onjob.equals("No"))
			{
				System.out.print("���벻�Ϸ�,����������:");
				onjob=input.nextLine().trim();
			}
			String[] param1 = {id,name,dept_id,super_id,onboard_date,resignation_date,onjob};
			int sign = perinformDao.updatePerinform(sql1, param1);
			if(sign>0)
				System.out.println("����Ա���ɹ�!");
			else
				System.out.println("����Ա����Ϣʧ��!");
			//input.close();
		}
			

	}

}
