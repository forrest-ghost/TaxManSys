package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Salary;
public interface SalaryDao {
	/*
	 * ������֪Ա����Ϣ��ѯԱ��ĳ�¹�����Ϣ
	 */
	public  List<Salary> selectSalary(String sql, Object[] param);
	
	/*
	 * ����Ա������
	 */
	public int updateSalary(String sql, Object[] param);
}
