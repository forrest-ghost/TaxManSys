package com.ssdut.taximanage.service;

import java.util.Date;
import java.util.List;

import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.entity.Perinform;

/*
	 * 快捷查询管理
	 */
public interface InquireManage {
	/*
	 * 根据司机姓名查找开了哪几辆车
	 */
	public List<Carinform> getCarinform(String taxName);
	
	/*
	 * 某天都有哪些司机上班
	 */
	public List<Perinform> getPerinform(Date date);
}
