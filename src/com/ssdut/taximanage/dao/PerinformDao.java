package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Perinform;


public interface PerinformDao {

	/*
	 * ��ѯ����Ա����Ϣ
	 */
	public  List<Perinform> getAllPerinform();
	
	/*
	 * ������֪Ա����Ϣ��ѯԱ����Ϣ
	 */
	public  Perinform selectPerinform(String sql, String[] param);
	
	/*
	 * ����Ա����Ϣ
	 */
	public int updatePerinform(String sql, String[] param);
}
