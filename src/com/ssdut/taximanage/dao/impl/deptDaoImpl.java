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

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	@Override
	public List<dept> getAlldept() {
		List<dept> deptList = new ArrayList<dept>(); 
		try {
			String preparedSql = "select dept_id,dept_name from dept ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

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
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
			}
		}
		rs = pstmt.executeQuery(); // ִ��SQL���
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
