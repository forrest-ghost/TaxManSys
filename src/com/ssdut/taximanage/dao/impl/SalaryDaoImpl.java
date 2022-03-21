package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.SalaryDao;
import com.ssdut.taximanage.entity.Salary;

public class SalaryDaoImpl extends BaseDao implements SalaryDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Salary> selectSalary(String sql, Object[] param) {
		List<Salary> salaryList = new ArrayList<Salary>();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
			}
		}
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Salary salary = new Salary();
				salary.setId(rs.getString(1));
				salary.setYear(rs.getInt(2));
				salary.setMonth(rs.getInt(3));
				salary.setDay_num(rs.getInt(4));
				salary.setSalary_standard(rs.getDouble(5));
				salary.setWage(rs.getDouble(6));
				
				salaryList.add(salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(salaryList.isEmpty()) {
			return null;
		}
		else {
			return salaryList;
		}
	}

	@Override
	public int updateSalary(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
