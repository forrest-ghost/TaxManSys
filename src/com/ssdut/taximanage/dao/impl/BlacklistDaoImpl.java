package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.BlacklistDao;
import com.ssdut.taximanage.entity.Blacklist;
import com.ssdut.taximanage.service.DatetoString;

public class BlacklistDaoImpl extends BaseDao implements BlacklistDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Blacklist> getAllBlacklist() {
		List<Blacklist> blacklistList = new ArrayList<Blacklist>(); 
		try {
			String preparedSql = "select ip_address,login_time from Blacklist ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				Blacklist blacklist = new Blacklist();
				blacklist.setIp_address(rs.getString(1));
				blacklist.setLogin_time(DatetoString.stringtoDateTime(rs.getString(2)));
				
				blacklistList.add(blacklist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(blacklistList.isEmpty()) {
			return null;
		}
		else {
			return blacklistList;
		}
	}

	@Override
	public List<Blacklist> selectBlacklist(String sql, String[] param) {
		List<Blacklist> blacklistList = new ArrayList<Blacklist>();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Blacklist blacklist = new Blacklist();
				blacklist.setIp_address(rs.getString(1));
				blacklist.setLogin_time(DatetoString.stringtoDateTime(rs.getString(2)));
				
				blacklistList.add(blacklist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(blacklistList.isEmpty()) {
			return null;
		}
		else {
			return blacklistList;
		}
	}

	@Override
	public int updateBlacklist(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
