package com.ssdut.taximanage.service;

import java.util.List;

import com.ssdut.taximanage.entity.Carinform;

/*
	 * 车辆管理
	 */
public interface CarinformManage {
	/*
	 * 查询所有车辆信息
	 */
	public List<Carinform> getAllCarinform();
	
	/*
	 * 查询某辆车信息
	 */
	public Carinform getCarinform(String car_id);
	
	/*
	 * 改某辆车信息
	 */
	public void setCarinform(String car_id);
	
	/*
	 * 增加一辆车信息
	 */
	public void addCarinform(String car_id);
}
