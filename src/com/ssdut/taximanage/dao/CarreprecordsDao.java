package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Carreprecords;
public interface CarreprecordsDao {
	/*
	 * ������֪������Ϣ��ѯ����ά����Ϣ
	 */
	public  List<Carreprecords> selectCarreprecords(String sql, String[] param);
	
	/*
	 * ���³���ά����Ϣ
	 */
	public int updateCarreprecords(String sql, String[] param);
}
