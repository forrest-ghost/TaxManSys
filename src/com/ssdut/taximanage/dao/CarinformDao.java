package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Carinform;


public interface CarinformDao {
	/*
	 * ��ѯ���г�����Ϣ
	 */
	public  List<Carinform> getAllCarinform();
	
	/*
	 * ������֪������Ϣ��ѯ������Ϣ
	 */
	public  Carinform selectCarinform(String sql, String[] param);
	
	/*
	 * ���³�����Ϣ
	 */
	public int updateCarinform(String sql, String[] param);
}
