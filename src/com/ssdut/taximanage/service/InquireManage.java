package com.ssdut.taximanage.service;

import java.util.Date;
import java.util.List;

import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.entity.Perinform;

/*
	 * ��ݲ�ѯ����
	 */
public interface InquireManage {
	/*
	 * ����˾���������ҿ����ļ�����
	 */
	public List<Carinform> getCarinform(String taxName);
	
	/*
	 * ĳ�춼����Щ˾���ϰ�
	 */
	public List<Perinform> getPerinform(Date date);
}
