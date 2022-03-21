package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Carreprecords;
public interface CarreprecordsDao {
	/*
	 * 根据已知车辆信息查询车辆维修信息
	 */
	public  List<Carreprecords> selectCarreprecords(String sql, String[] param);
	
	/*
	 * 更新车辆维修信息
	 */
	public int updateCarreprecords(String sql, String[] param);
}
