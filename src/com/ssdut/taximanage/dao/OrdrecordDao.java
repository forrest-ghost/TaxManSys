package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Ordrecord;

public interface OrdrecordDao {
	/*
	 * 根据已知订单信息查询订单记录
	 */
	public  List<Ordrecord> selectOrdrecord(String sql, String[] param);
	
	/*
	 * 更新订单记录
	 */
	public int updateOrdrecord(String sql, String[] param);
}
