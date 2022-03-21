package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.entity.Perinform;
import com.ssdut.taximanage.service.DatetoString;

public class PerinformDaoImpl extends BaseDao implements com.ssdut.taximanage.dao.PerinformDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Perinform> getAllPerinform() {
		List<Perinform> perinformList = new ArrayList<Perinform>(); 
		try {
			String preparedSql = "select id,name,dept_id,super_id,onboard_date,resignation_date,onjob from Perinform ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				Perinform perinform = new Perinform();
				perinform.setId(rs.getString(1));
				perinform.setName(rs.getString(2));
				perinform.setDept_id(rs.getString(3));
				perinform.setSuper_id(rs.getString(4));
				perinform.setOnboard_date(DatetoString.stringtoDate(rs.getString(5)));
				perinform.setResignation_date(DatetoString.stringtoDate(rs.getString(6)));
				perinform.setOnjob(rs.getString(7));
				
				perinformList.add(perinform);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(perinformList.isEmpty()) {
			return null;
		}
		else {
			return perinformList;
		}
	}

	@Override
	public Perinform selectPerinform(String sql, String[] param) {
		Perinform perinform = new Perinform();
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
				
				perinform.setId(rs.getString(1));
				perinform.setName(rs.getString(2));
				perinform.setDept_id(rs.getString(3));
				perinform.setSuper_id(rs.getString(4));
				perinform.setOnboard_date(DatetoString.stringtoDate(rs.getString(5)));
				perinform.setResignation_date(DatetoString.stringtoDate(rs.getString(6)));
				perinform.setOnjob(rs.getString(7));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(perinform.getId()!=null) {
			return perinform;
		}
		else {
			return null;
		}
	}

	@Override
	public int updatePerinform(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
