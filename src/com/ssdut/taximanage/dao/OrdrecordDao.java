package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Ordrecord;

public interface OrdrecordDao {
	/*
	 * ������֪������Ϣ��ѯ������¼
	 */
	public  List<Ordrecord> selectOrdrecord(String sql, String[] param);
	
	/*
	 * ���¶�����¼
	 */
	public int updateOrdrecord(String sql, String[] param);
}
