package com.ssdut.taximanage.service;

import java.io.Console;
import com.ssdut.taximanage.entity.Usermanage;

public interface LoginModule {
	/*
	 * �û���¼
	 */
	public Usermanage login() ;
	
	/*
	 * �û�ע��
	 */
	public void registered();
	
	/*
	 * ��ѯ�û����Ƿ��ظ�
	 */
	public boolean getUsername(String username);
	
	/*
	 * ����ʾ��������
	 *
	 */
	 public static String inputStringNotEcho(){
			Console console = System.console();
			return new String(console.readPassword());
		}
}
