package com.ssdut.taximanage.service;

import com.ssdut.taximanage.entity.Perinform;
import java.util.List;

/*
	 * ��Ա����
	 */
public interface PerinformManage {
	/*
	 * �鿴����Ա��
	 */
	public List<Perinform> getAllPerionform();
	
	/*
	 * ��ѯĳ�˵���Ϣ
	 */
	public Perinform getPerinform(String id);
	
	/*
	 * ����Ա����Ϣ(�ģ���ɾ��)
	 */
	public void setPerinform(String id);
	
	/*
	 * ����һ��Ա��
	 * 
	 */
	public void addPerinform(String id);
}
