package com.ssdut.taximanage.service;

import java.util.Date;
import java.util.List;

import com.ssdut.taximanage.entity.Logrecord;

public interface Loginusermanage {
	/*
	 * ��ѯ�û�״̬,���ص�ǰ�û�״̬
	 */
	public String getStatus(String userName);
	
	/*
	 * �������¼����˻�
	 */
	public void setStatus(String userName);
	
	/*
	 * �鿴��¼��¼
	 */
	public List<Logrecord> getLogrecord(String userName);
}
