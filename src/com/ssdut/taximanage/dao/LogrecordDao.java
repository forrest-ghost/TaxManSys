package com.ssdut.taximanage.dao;
import java.util.List;

import com.ssdut.taximanage.entity.Logrecord;
public interface LogrecordDao {

	/*
	 * ��ѯ���е�¼��¼��Ϣ
	 */
	public  List<Logrecord> getAllLogrecord();
	
	/*
	 * ������֪��¼��¼��Ϣ��ѯ��¼��Ϣ
	 */
	public  List<Logrecord> selectLogrecord(String sql, String[] param);
	
	/*
	 * ���µ�¼��¼��Ϣ
	 */
	public int updateLogrecord(String sql, String[] param);
}
