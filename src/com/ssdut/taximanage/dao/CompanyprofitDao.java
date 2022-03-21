package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Companyprofit;
public interface CompanyprofitDao {
	/*
	 * 查询所有的公司盈利信息
	 */
	public  List<Companyprofit> getAllCompanyprofit();
	
	/*
	 * 根据已知月份信息查询公司月盈利信息
	 */
	public  List<Companyprofit> selectCompanyprofit(String sql, String[] param);
	
	/*
	 * 更新盈利信息
	 */
	public int updateCompanyprofit(String sql, String[] param);
}
