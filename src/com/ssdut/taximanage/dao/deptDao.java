package com.ssdut.taximanage.dao;

import java.util.List;

import com.ssdut.taximanage.entity.dept;
public interface deptDao {
	/*
	 * ��ѯ���в�����Ϣ
	 */
	public  List<dept> getAlldept();
	
	/*
	 * ������֪������Ϣ��ѯ������Ϣ
	 */
	public  List<dept> selectdept(String sql, String[] param);
	
	/*
	 * ���²�����Ϣ
	 */
	public int updatedept(String sql, String[] param);
}
