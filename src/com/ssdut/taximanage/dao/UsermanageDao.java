package com.ssdut.taximanage.dao;
import java.util.List;

import com.ssdut.taximanage.entity.Usermanage;
public interface UsermanageDao {
	/*
	 * 查询所有登录用户信息
	 */
	public  List<Usermanage> getAllUsermanage();
	
	/*
	 * 根据已知登录用户信息查询登录用户信息
	 */
	public  Usermanage selectUsermanage(String sql, String[] param);
	
	/*
	 * 更新登录用户信息
	 */
	public int updateUsermanage(String sql, String[] param);
}
