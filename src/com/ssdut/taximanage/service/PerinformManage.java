package com.ssdut.taximanage.service;

import com.ssdut.taximanage.entity.Perinform;
import java.util.List;

/*
	 * 人员管理
	 */
public interface PerinformManage {
	/*
	 * 查看所有员工
	 */
	public List<Perinform> getAllPerionform();
	
	/*
	 * 查询某人的信息
	 */
	public Perinform getPerinform(String id);
	
	/*
	 * 更改员工信息(改，不删除)
	 */
	public void setPerinform(String id);
	
	/*
	 * 增加一名员工
	 * 
	 */
	public void addPerinform(String id);
}
