package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.LogrecordDao;
import com.ssdut.taximanage.entity.Logrecord;
import com.ssdut.taximanage.service.DatetoString;

public class LogrecordDaoImpl extends BaseDao implements LogrecordDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Logrecord> getAllLogrecord() {
		List<Logrecord> LogrecordList = new ArrayList<Logrecord>(); 
		try {
			String preparedSql = "select Log_id,passwd,time,Log_ip from Blacklist ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				Logrecord logrecord = new Logrecord();
				logrecord.setLog_id(rs.getString(1));
				logrecord.setPasswd(rs.getString(2));
				logrecord.setTime(DatetoString.stringtoDateTime(rs.getString(3)));
				logrecord.setLog_ip(rs.getString(4));
				
				LogrecordList.add(logrecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(LogrecordList.isEmpty()) {
			return null;
		}
		else {
			return LogrecordList;	
		}
		}

	@Override
	public List<Logrecord> selectLogrecord(String sql, String[] param) {
		List<Logrecord> LogrecordList = new ArrayList<Logrecord>(); 
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
				Logrecord logrecord = new Logrecord();
				logrecord.setLog_id(rs.getString(1));
				logrecord.setPasswd(rs.getString(2));
				logrecord.setTime(DatetoString.stringtoDateTime(rs.getString(3)));
				logrecord.setLog_ip(rs.getString(4));
				
				LogrecordList.add(logrecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(LogrecordList.isEmpty()) {
			return null;
		}
		else {
			return LogrecordList;
		}
	}

	@Override
	public int updateLogrecord(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
