package com.ssdut.taximanage.dao;
import java.util.List;

import com.ssdut.taximanage.entity.Usermanage;
public interface UsermanageDao {
	/*
	 * ��ѯ���е�¼�û���Ϣ
	 */
	public  List<Usermanage> getAllUsermanage();
	
	/*
	 * ������֪��¼�û���Ϣ��ѯ��¼�û���Ϣ
	 */
	public  Usermanage selectUsermanage(String sql, String[] param);
	
	/*
	 * ���µ�¼�û���Ϣ
	 */
	public int updateUsermanage(String sql, String[] param);
}
