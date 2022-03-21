package com.ssdut.taximanage.dao;
import java.util.List;

import com.ssdut.taximanage.entity.Logrecord;
public interface LogrecordDao {

	/*
	 * 查询所有登录记录信息
	 */
	public  List<Logrecord> getAllLogrecord();
	
	/*
	 * 根据已知登录记录信息查询登录信息
	 */
	public  List<Logrecord> selectLogrecord(String sql, String[] param);
	
	/*
	 * 更新登录记录信息
	 */
	public int updateLogrecord(String sql, String[] param);
}
