package com.ssdut.taximanage.service;

import java.util.List;

import com.ssdut.taximanage.entity.Salary;

public interface SalaryManage {
	/*
	 * 根据司机id查询某司机某个月的上班天数和薪资情况列表
	 */
	public List<Salary> getSalary(String id);
	
	/*
	 * 更新Salary表
	 * 从出勤记录表Attendance查询更新薪资表
	 * 根据司机id更新
	 */
	public void updateSalary(String id);
}
