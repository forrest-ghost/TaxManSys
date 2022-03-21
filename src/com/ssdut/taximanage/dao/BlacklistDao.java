package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Blacklist;
public interface BlacklistDao {
	/*
	 * 查询所有黑名单
	 */
	public  List<Blacklist> getAllBlacklist();
	
	/*
	 * 根据已知黑名单信息查询黑名单记录
	 */
	public  List<Blacklist> selectBlacklist(String sql, String[] param);
	
	/*
	 * 更新黑名单记录
	 */
	public int updateBlacklist(String sql, String[] param);
}
