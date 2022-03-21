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
	 * ��ʼģ��
	 */
	private static void startTaxiManage() {
		LoginModule Login = new LoginModuleImpl();
		Scanner input = new Scanner(System.in);
		Usermanage user = new Usermanage();
		System.out.println("-----------��ӭʹ�ó��⳵��˾����ϵͳ-----------");
		System.out.println("ѡ����Ҫִ�еĲ�����");
		System.out.println("1,��¼ϵͳ");
		System.out.println("2,ע���˺�");
		int type = input.nextInt();
		while(type!=1&&type!=2)
		{
			System.out.println("�������,������ѡ������");
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
				System.out.println("��¼ʧ��");
			}
		}
		else {
			Login.registered();
			//��¼
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
				System.out.println("��¼ʧ��");
			}
		}
		input.close();
	}
	
	/*
	 * ����Ա��¼,�����в�ѯ��¼�û�״̬�����ĵ�¼�û�״̬���鿴��¼��¼,����н�ʱ�
	 */
	private static void rootLogin() {
		boolean flag = true;//�˳�ϵͳ����
		int type = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("---��ǰ״̬Ϊ����Ա�û�,��ѡ����Ҫִ�еĲ���---");
		while(flag) {
			System.out.println("1,��ѯĳ���˺ŵĵ�ǰ״̬");
			System.out.println("2,����ĳ���˺ŵĵ�ǰ״̬");
			System.out.println("3,��ѯĳ�˺ŵĵ�¼��¼");
			System.out.println("4,����ĳ˾����н�ʱ�");
			System.out.println("5,�˳���¼");
			System.out.println("�������Ӧ����Ž��в���");
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
					System.out.println("�������,�����²���");
					break;
			}
		}
		input.close();
	}
	
	/*
	 * 1,����ģ��һ����ѯĳ�˺ŵĵ�ǰ״̬�������û���������û�״̬
	 */
	private static void findStatus() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("������Ҫ��ѯ���û�:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		String status = loginuserManage.getStatus(username);
		if(status!=null) {
			System.out.println("��ѯ�������:");
			System.out.println("�˻�"+username+"��ǰ״̬Ϊ:"+status);
		}
		else {
			System.out.println("��ѯʧ�ܣ������ڸ��û�");
		}
		//input.close();
	}
	
	/*
	 * 2,����ģ���������ĳ���˺ŵĵ�ǰ״̬
	 */
	private static void setStatus() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("������Ҫ������Ϣ���û�����:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		loginuserManage.setStatus(username);
		//input.close();
	}
	
	/*
	 * 3,����ģ��������ѯĳ�˻���¼��¼
	 */
	private static void findLoginrecord() {
		Loginusermanage loginuserManage = new LoginusermanageImpl();
		System.out.println("������Ҫ��ѯ��¼���û�����:");
		Scanner input = new Scanner(System.in);
		String username = input.nextLine().trim();
		List<Logrecord> logrecordList = loginuserManage.getLogrecord(username);
		if(logrecordList!=null) {
			System.out.println(username+"�ĵ�¼��¼����:");
			System.out.println("��¼ʱ��\t"+"��¼IP");
			for(int i=0;i<logrecordList.size();i++) {
				System.out.println(DatetoString.datetimetoString(logrecordList.get(i).getTime())+"\t"+logrecordList.get(i).getLog_ip());
			}
		}
		//input.close();
	}
	
	/*
	 * 4������ģ����,����ĳ˾����н�ʱ�
	 */
	private static void updateSalary() {
		SalaryManage salaryManage = new SalaryManageImpl();
		System.out.println("������Ҫ���µ�˾�����:");
		Scanner input = new Scanner(System.in);
		String id = input.nextLine().trim();
		salaryManage.updateSalary(id);
		//input.close();
	}
	
	/*
	 * һ���û���¼,ֻ�в�ѯȨ�ޣ���ѯ��ǰ������Ϣ����Ա��Ϣ��һ��˾��(˾��id)���ϰ�������н�����������˾�������鿴�����ļ���������Щ�춼����Щ˾���ϰ�
	 */
	private static void userLogin() {
		boolean flag = true;//�˳�ϵͳ����
		Scanner input = new Scanner(System.in);
		System.out.println("---��ǰ״̬Ϊ��ͨ�û�,��ѡ����Ҫִ�еĲ���---");
		while(flag) {
			System.out.println("1,�鿴��ǰ������Ϣ");
			System.out.println("2,�鿴��ǰԱ����Ϣ");
			System.out.println("3,��ѯĳ˾�����ϰ�������н�����");
			System.out.println("4,��ѯĳ˾�������ļ�����");
			System.out.println("5,��ѯĳ���ϰ��˾��");
			System.out.println("6,�˳���¼");
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
					System.out.println("�������,����������");
					break;
			}
		}
		input.close();
	}
	
	/*
	 * ����ģ��һ����ѯ������Ϣ
	 */
	private static void findCarinform() {
		CarinformManage carinformManage = new CarinformManageImpl();
		List<Carinform> carinformList = new ArrayList<Carinform>();
		Scanner input = new Scanner(System.in);
		carinformList = carinformManage.getAllCarinform();
		if(carinformList!=null) {
			System.out.println("�������\t"+"�������ű��");
			for(int i=0;i<carinformList.size();i++) {
				System.out.println(carinformList.get(i).getCar_id()+"\t"+carinformList.get(i).getDept_id());
			}
			System.out.println();
			System.out.println("�Ƿ������ѯĳ��������ϸ��Ϣ:1,������ѯ 2��������һ���˵�");
			int type = input.nextInt();
			while(type!=1&&type!=2&&!input.hasNextInt()) {
				System.out.println("���������������������1��2");
				type = input.nextInt();
				
			}
			if(type==1) {
				System.out.println("������Ҫ��ѯ�ĳ������");
				String strnull = input.nextLine();
				String car_id = input.nextLine();
				System.out.println(car_id);
				Carinform carinform = carinformManage.getCarinform(car_id);
				if(carinform!=null) {
					System.out.println("�������\t"+"���ű��\t"+"���ۿ�ʼʱ��\t"+"���۽���ʱ��");
					String datestart = DatetoString.datetoString(carinform.getOnboard_time());
					String dateend = DatetoString.datetimetoString(carinform.getResign_time());
					System.out.println(carinform.getCar_id()+"\t"+carinform.getDept_id()+"\t"+datestart+"\t"+dateend);
				}
				else {
					System.out.println("û�����������");
				}
			}
		}
		else {
			System.out.println("��ǰû�г������ݣ�����ϵ����Ա����");
		}
		//input.close();
	}
	
	/*
	 * ����ģ�������ѯ��Ա��Ϣ
	 */
	private static void findPerinform() {
		PerinformManage perinformManage = new PerinformManageImpl();
		List<Perinform> perinformList = new ArrayList<Perinform>();
		Scanner input = new Scanner(System.in);
		perinformList = perinformManage.getAllPerionform();
		if(perinformList!=null) {
			System.out.println("Ա�����\t"+"Ա������");
			for(int i=0;i<perinformList.size();i++) {
				System.out.println(perinformList.get(i).getId()+"\t"+perinformList.get(i).getName());
			}
			System.out.println();
			
			System.out.println("�Ƿ������ѯĳΪԱ������ϸ��Ϣ:1,������ѯ 2��������һ���˵�");
			int type = input.nextInt();
			while(type!=1&&type!=2) {
				System.out.println("�����������������");
				type = input.nextInt();
			}
			if(type==1) {
				System.out.println("������Ҫ��ѯ��Ա�����");
				String strnull = input.nextLine();
				String id = input.nextLine().trim();
				Perinform perinform = perinformManage.getPerinform(id);
				if(perinform!=null) {
					String datestart = DatetoString.datetoString(perinform.getOnboard_date());
					String dateend = DatetoString.datetoString(perinform.getResignation_date());
					System.out.println("Ա�����\t"+"Ա������\t"+"���ű��\t"+"�ϼ����\t"+"��ְʱ��\t"+"��ְʱ��\t"+"�Ƿ���ְ");
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
					System.out.println("û�����Ա�����");
				}
			}
		}
		else {
			System.out.println("��ǰû����Ա���ݣ�����ϵ����Ա����");
		}
		//input.close();
	}
	
	/*
	 * һ��˾�����ϰ�������н�����
	 */
	private static void findSalary() {
			SalaryManage salaryManage = new SalaryManageImpl();
			List<Salary> salaryList = new ArrayList<Salary>();
			Scanner input = new Scanner(System.in);
			System.out.println("������Ҫ��ѯ��˾�����");
			String id = input.nextLine().trim();
			salaryList = salaryManage.getSalary(id);
			if(salaryList!=null) {
				System.out.println("˾�����\t"+"���\t"+"�·�\t"+"�ϰ�����\t"+"���¹���");
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
	 * ����˾�������鿴˾�������ļ�����
	 */
	private static void findCars() {
		InquireManage inquireManage = new InquireManageImpl();
		List<Carinform> carinformList = new ArrayList<Carinform>();
		System.out.println("������Ҫ��ѯ��˾������:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine().trim();
		carinformList = inquireManage.getCarinform(name);
		if(carinformList!=null) {
			System.out.println("˾��"+name+"�����ĳ����������:");
			for(int i=0;i<carinformList.size();i++) {
				System.out.println(carinformList.get(i).getCar_id());
			}
		}
		//input.close();
	}
	
	/*
	 * ��Щ�춼����Щ˾���ϰ�
	 */
	private static void findPers() {
		InquireManage inquireManage = new InquireManageImpl();
		Date date = new Date();
		Scanner input = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ������:��ʽΪ ��-��-��");
		String strdate = input.nextLine().trim();
		date = DatetoString.stringtoDate(strdate);
		List<Perinform> perinformList = inquireManage.getPerinform(date);
		if(perinformList!=null) {
			System.out.println("�����ϰ��Ա����Ϣ����:");
			System.out.println("Ա�����\t"+"Ա������");
			for(int i=0;i<perinformList.size();i++) {
				System.out.println(perinformList.get(i).getId()+"\t"+perinformList.get(i).getName());
			}
		}
		else {
			System.out.println("��ѯ����û�е����ϰ�˾����Ϣ");
		}
		//input.close();
	}
}
