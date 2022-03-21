package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Salary;
public interface SalaryDao {
	/*
	 * 根据已知员工信息查询员工某月工资信息
	 */
	public  List<Salary> selectSalary(String sql, Object[] param);
	
	/*
	 * 更新员工工资
	 */
	public int updateSalary(String sql, Object[] param);
}
