package com.ssdut.taximanage.service;

import java.util.List;

import com.ssdut.taximanage.entity.Carinform;

/*
	 * ��������
	 */
public interface CarinformManage {
	/*
	 * ��ѯ���г�����Ϣ
	 */
	public List<Carinform> getAllCarinform();
	
	/*
	 * ��ѯĳ������Ϣ
	 */
	public Carinform getCarinform(String car_id);
	
	/*
	 * ��ĳ������Ϣ
	 */
	public void setCarinform(String car_id);
	
	/*
	 * ����һ������Ϣ
	 */
	public void addCarinform(String car_id);
}
