package com.ssdut.taximanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ssdut.taximanage.dao.LogrecordDao;
import com.ssdut.taximanage.dao.UsermanageDao;
import com.ssdut.taximanage.dao.impl.LogrecordDaoImpl;
import com.ssdut.taximanage.dao.impl.UsermanageDaoImpl;
import com.ssdut.taximanage.entity.Logrecord;
import com.ssdut.taximanage.entity.Usermanage;
import com.ssdut.taximanage.service.Loginusermanage;
import com.ssdut.taximanage.service.MD5Utils;

public class LoginusermanageImpl implements Loginusermanage {

	@Override
	public String getStatus(String userName) {
		UsermanageDao usermanagedao = new UsermanageDaoImpl();
		String sql = "select * from Usermanage where user=?";
		String[] param = {MD5Utils.code(userName)};
		Usermanage usermanage = usermanagedao.selectUsermanage(sql, param);
		if(usermanage!=null)
		{
			/*
			 * ���ҳɹ�
			 */
			return usermanage.getStatus();
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public void setStatus(String userName) {
		UsermanageDao usermanagedao = new UsermanageDaoImpl();
		String sql = "select * from Usermanage where user=?";
		String[] param = {MD5Utils.code(userName)};
		int type=0;
		Usermanage usermanage = usermanagedao.selectUsermanage(sql, param);
		if(usermanage!=null)
		{
			/*
			 * ���ҳɹ�
			 */
			System.out.println("��ǰ�˻�״̬Ϊ:"+usermanage.getStatus());
			System.out.println("ѡ����Ҫ���ĵ�״̬:1,alive\t"+"2,freeze");
			System.out.println("�����Ӧ��ż���");
			Scanner input = new Scanner(System.in);
			if(input.hasNextInt()) {
				type = input.nextInt();
				while(type!=1&&type!=2)
				{
					System.out.println("�������,������1��2");
					type = input.nextInt();
				}
			}
			else {
				System.out.println("����������1����2");
			}
			
			int updateUsermanage=0;
			
			String updatesql = "update Usermanage set status=? where user=?";
			if(type==1)
			{
				String[] param1= {"alive",MD5Utils.code(userName)};
				updateUsermanage=usermanagedao.updateUsermanage(updatesql, param1);
			}
			else
			{
				String[] param2= {"freeze",MD5Utils.code(userName)};
				updateUsermanage=usermanagedao.updateUsermanage(updatesql, param2);
			}
			if(updateUsermanage>0)
			{
				System.out.println("���³ɹ�!");
			}
			else
			{
				System.out.println("����ʧ��!");
			}
			//input.close();
		}
		else
		{
			System.out.println("����ʧ�ܣ������ڸ��˻�");
			
		}

	}

	@Override
	public List<Logrecord> getLogrecord(String userName) {
		//List<Date> datelist = new ArrayList<Date>();
		LogrecordDao logrecordDao = new LogrecordDaoImpl();
		String sql = "select * from Logrecord where Log_id=?";
		String[] param = {MD5Utils.code(userName)};
		List<Logrecord> logrecordList = logrecordDao.selectLogrecord(sql, param);
		if(!logrecordList.isEmpty())
		{
			/*
			 * ���ҳɹ�
			 */
			return logrecordList;
		}
		System.out.println("�����ڸ��˺ŵĵ�¼��Ϣ!");
		return null;
		
	}

}
