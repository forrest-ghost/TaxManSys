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
		// 1�������˻�����
		System.out.println("���ȵ�¼�����������˻����ƣ�");
		String userName = input.nextLine().trim();
		System.out.println("�����������룺");
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
				System.out.println("-------��ϲ���ɹ���¼-------");
				System.out.println("-------���Ļ�����Ϣ��-------");
				System.out.println("�˻�����" + userName);
				System.out.println("�˻�״̬��" + owner.getStatus());
				if(owner.getLevel()<10)
				{
					System.out.println("�˻�Ȩ�ޣ�" + "һ���û�");
				}
				else
				{
					System.out.println("�˻�Ȩ�ޣ�" + "����Ա�˻�");
				}
				return owner;
			}
			else
			{
				System.out.println("����˻������쳣,����ϵ����Ա�����");
				return null;
			}
			
		}
		else {
			System.out.println("û�и��˺ţ������������˺Ż�ע��һ���˺ţ�����");
			return null;
		}
		
	}

	@Override
	public void registered() {
		UsermanageDao userDao = new UsermanageDaoImpl();
		List<Usermanage> userlist = userDao.getAllUsermanage();
		String userName="С��";
		String userPassword="123";
		Scanner input = new Scanner(System.in);
		boolean flag=true;
		if(userlist != null)
		{
			// 1�������˻�����
			while(flag)
			{
				System.out.println("���������˻����ƣ�");
				userName = input.nextLine().trim();
				while(!this.getUsername(userName))
				{
					System.out.println("�˻����ظ�������������");
					userName = input.nextLine().trim();
				}
				System.out.println("�����������룺");
				userPassword = input.nextLine().trim();
				System.out.println("�����ٴ��������룺");
				String userPassword1 = input.nextLine().trim();
				if(!userPassword.equals(userPassword1))
				{
					System.out.println("�������벻ͬ�����������룡����");
				}
				else
				{
					System.out.println("�˻�ע��ɹ���");
					flag =false;
				}
			}
			String sql = "INSERT INTO Usermanage(user,passwd,status,level) values(?,?,'alive',1)";
			String[] param = { MD5Utils.code(userName), MD5Utils.code(userPassword) };
			userDao.updateUsermanage(sql, param);
		}
		else
		{
			System.out.println("��ϵͳĿǰ��û���û����㽫��Ϊ��ϵͳ�Ĺ���Ա��");
			System.out.println("�Ƿ����ע�᣺Yes or No!");
			String type = input.nextLine().trim();
			while(!"Yes".equals(type)&&!"No".equals(type))
			{
				System.out.println("�������������Yes����No");
				type = input.nextLine().trim();
			}
			if("No".equals(type))
			{
				flag =false;
			}
			// 1�������˻�����
						while(flag)
						{
							System.out.println("���������˻����ƣ�");
							userName = input.nextLine().trim();
							while(!this.getUsername(userName))
							{
								System.out.println("�˻����ظ�������������");
								userName = input.nextLine().trim();
							}
							System.out.println("�����������룺");
							userPassword = input.nextLine().trim();
							System.out.println("�����ٴ��������룺");
							String userPassword1 = input.nextLine().trim();
							if(!userPassword.equals(userPassword1))
							{
								System.out.println("�������벻ͬ�����������룡����");
							}
							else
							{
								System.out.println("�˻�ע��ɹ���");
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
			return true;//�˻����Ʋ��ظ�
		else
			return false;//�˻������ظ�
	}
}
