package com.ssdut.taximanage.service;

import java.util.List;

import com.ssdut.taximanage.entity.Salary;

public interface SalaryManage {
	/*
	 * ����˾��id��ѯĳ˾��ĳ���µ��ϰ�������н������б�
	 */
	public List<Salary> getSalary(String id);
	
	/*
	 * ����Salary��
	 * �ӳ��ڼ�¼��Attendance��ѯ����н�ʱ�
	 * ����˾��id����
	 */
	public void updateSalary(String id);
}
