package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Perinform;


public interface PerinformDao {

	/*
	 * 查询所有员工信息
	 */
	public  List<Perinform> getAllPerinform();
	
	/*
	 * 根据已知员工信息查询员工信息
	 */
	public  Perinform selectPerinform(String sql, String[] param);
	
	/*
	 * 更新员工信息
	 */
	public int updatePerinform(String sql, String[] param);
}
