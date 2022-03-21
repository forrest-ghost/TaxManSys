package com.ssdut.taximanage.service;

import java.util.Date;
import java.util.List;

import com.ssdut.taximanage.entity.Logrecord;

public interface Loginusermanage {
	/*
	 * 查询用户状态,返回当前用户状态
	 */
	public String getStatus(String userName);
	
	/*
	 * 帮助重新激活账户
	 */
	public void setStatus(String userName);
	
	/*
	 * 查看登录记录
	 */
	public List<Logrecord> getLogrecord(String userName);
}
