package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Companyprofit;
public interface CompanyprofitDao {
	/*
	 * ��ѯ���еĹ�˾ӯ����Ϣ
	 */
	public  List<Companyprofit> getAllCompanyprofit();
	
	/*
	 * ������֪�·���Ϣ��ѯ��˾��ӯ����Ϣ
	 */
	public  List<Companyprofit> selectCompanyprofit(String sql, String[] param);
	
	/*
	 * ����ӯ����Ϣ
	 */
	public int updateCompanyprofit(String sql, String[] param);
}
