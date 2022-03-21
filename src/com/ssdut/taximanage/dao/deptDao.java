package com.ssdut.taximanage.dao;

import java.util.List;

import com.ssdut.taximanage.entity.dept;
public interface deptDao {
	/*
	 * 查询所有部门信息
	 */
	public  List<dept> getAlldept();
	
	/*
	 * 根据已知部门信息查询部门信息
	 */
	public  List<dept> selectdept(String sql, String[] param);
	
	/*
	 * 更新部门信息
	 */
	public int updatedept(String sql, String[] param);
}
