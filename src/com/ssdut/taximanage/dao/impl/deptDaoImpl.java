package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.deptDao;
import com.ssdut.taximanage.entity.dept;

public class deptDaoImpl extends BaseDao implements deptDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<dept> getAlldept() {
		List<dept> deptList = new ArrayList<dept>(); 
		try {
			String preparedSql = "select dept_id,dept_name from dept ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				dept dept = new dept();
				dept.setDept_id(rs.getString(1));
				dept.setDept_name(rs.getString(2));
				
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(deptList.isEmpty()) {
			return null;
		}
		else {
			return deptList;
		}
	}

	@Override
	public List<dept> selectdept(String sql, String[] param) {
		List<dept> deptList = new ArrayList<dept>();
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
				dept dept = new dept();
				dept.setDept_id(rs.getString(1));
				dept.setDept_name(rs.getString(2));
				
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(deptList.isEmpty()) {
			return null;
		}
		else {
			return deptList;
		}
	}

	@Override
	public int updatedept(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
