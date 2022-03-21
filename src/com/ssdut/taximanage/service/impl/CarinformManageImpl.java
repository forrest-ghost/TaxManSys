package com.ssdut.taximanage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.dao.CarinformDao;
import com.ssdut.taximanage.dao.impl.CarinformDaoImpl;
import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.service.CarinformManage;

public class CarinformManageImpl implements CarinformManage {
	@Override
	public List<Carinform> getAllCarinform(){
		List<Carinform> carinformList = new ArrayList<Carinform>();
		CarinformDao carinformDao = new CarinformDaoImpl();
		carinformList = carinformDao.getAllCarinform();
		return carinformList;
	}

	@Override
	public Carinform getCarinform(String car_id) {
		Carinform carinform=new Carinform();
		CarinformDao carinformDao = new CarinformDaoImpl();
		String sql = "select * from Carinform where car_id=?";
		String[] param = {car_id};
		carinform = carinformDao.selectCarinform(sql, param);
		return carinform;
	}

	@Override
	public void setCarinform(String car_id) {
		// ��
		
		Carinform carinform = new Carinform();
		CarinformDao carinformDao = new CarinformDaoImpl();
		String sql = "select * from Carinform where car_id=?";
		String[] param = {car_id};
		carinform = carinformDao.selectCarinform(sql, param);
		if(carinform!=null)
		{
			System.out.println("��ѡ����Ҫ���ĵ���Ϣ��");
			System.out.println("1,�����������ű�� 2,���ۿ�ʼʱ�� 3,���۽���ʱ��");
			Scanner input = new Scanner(System.in);
			int type=input.nextInt();
			while(type!=1&&type!=2&&type!=3)
			{
				System.out.println("�������");
				System.out.println("����������:");
				type=input.nextInt();
			}
			switch(type)
			{
			case 1:
				String sql1 = "update Carinform set dept_id=? where car_id=?";
				System.out.println("�������µĲ��ű��");
				String str = input.nextLine().trim();
				String[] param1= {str,car_id};
				carinformDao.updateCarinform(sql1, param1);
				break;
			case 2:
				String sql2 = "update Carinform set onboard_time=? where car_id=?";
				System.out.println("�������µķ��ۿ�ʼʱ��");
				System.out.println("ʱ���ʽΪ����-��-��");
				String str1 = input.nextLine().trim();
				String[] param2= {str1,car_id};
				carinformDao.updateCarinform(sql2, param2);
				break;
			case 3:
				String sql3 = "update Carinform set onboard_time=? where car_id=?";
				System.out.println("�������µķ��۽���ʱ��");
				System.out.println("ʱ���ʽΪ����-��-��");
				String str2 = input.nextLine().trim();
				String[] param3= {str2,car_id};
				carinformDao.updateCarinform(sql3, param3);
				break;
			}
			//input.close();
		}
		else
		{
			System.out.println("�������󣬲�����������");
		}
	}
	
	@Override
	public void addCarinform(String car_id) {
		Scanner input = new Scanner(System.in);
		Carinform carinform = new Carinform();
		CarinformDao carinformDao = new CarinformDaoImpl();
		String sql = "select * from Carinform where car_id=?";
		String[] param = {car_id};
		carinform = carinformDao.selectCarinform(sql, param);
		if(carinform!=null)
		{
			System.out.println("�ó�������Ѵ��ڣ�����������");
		}
		else
		{
			System.out.println("�����복���������ű��:");
			String dept_id = input.next().trim();
			System.out.println("�����복�����ۿ�ʼʱ��:");
			String onboard_time = input.next().trim();
			System.out.println("�����복�����۽���ʱ��:");
			String resign_time = input.next().trim();
			String sql1 = "Insert into Carinform (car_id,dept_id,onboard_time,resign_time) values(?,?,?,?)";
			String[] param1 = {car_id,dept_id,onboard_time,resign_time};
			int flag = carinformDao.updateCarinform(sql1, param1);
			if(flag>0)
			{
				System.out.println("��ӳɹ���");
				
			}
			else
			{
				System.out.println("���ʧ�ܣ�");
			}
		}
		//input.close();
	}
}
