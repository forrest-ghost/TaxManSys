package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Carinform;


public interface CarinformDao {
	/*
	 * 查询所有车辆信息
	 */
	public  List<Carinform> getAllCarinform();
	
	/*
	 * 根据已知车辆信息查询车辆信息
	 */
	public  Carinform selectCarinform(String sql, String[] param);
	
	/*
	 * 更新车辆信息
	 */
	public int updateCarinform(String sql, String[] param);
}
