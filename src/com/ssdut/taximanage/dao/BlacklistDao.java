package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Blacklist;
public interface BlacklistDao {
	/*
	 * ��ѯ���к�����
	 */
	public  List<Blacklist> getAllBlacklist();
	
	/*
	 * ������֪��������Ϣ��ѯ��������¼
	 */
	public  List<Blacklist> selectBlacklist(String sql, String[] param);
	
	/*
	 * ���º�������¼
	 */
	public int updateBlacklist(String sql, String[] param);
}
