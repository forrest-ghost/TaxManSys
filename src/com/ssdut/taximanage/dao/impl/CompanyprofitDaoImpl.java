package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.CompanyprofitDao;
import com.ssdut.taximanage.entity.Companyprofit;

public class CompanyprofitDaoImpl extends BaseDao implements CompanyprofitDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Companyprofit> getAllCompanyprofit() {
		List<Companyprofit> CompanyprofitList = new ArrayList<Companyprofit>(); 
		try {
			String preparedSql = "select year,month,rep_cost,salary_standard,salary_cost,other_cost,order_income,other_income,total_profit from Companyprofit ";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			rs = pstmt.executeQuery(); // 执行SQL语句

			while (rs.next()) {

				Companyprofit companyprofit = new Companyprofit();
				companyprofit.setYear(rs.getInt(1));
				companyprofit.setMonth(rs.getInt(2));
				companyprofit.setRep_cost(rs.getDouble(3));
				companyprofit.setSalary_standard(rs.getDouble(4));
				companyprofit.setSalary_cost(rs.getDouble(5));
				companyprofit.setOther_cost(rs.getDouble(6));
				companyprofit.setOrder_income(rs.getDouble(7));
				companyprofit.setOther_income(rs.getDouble(8));
				companyprofit.setTotal_profit(rs.getDouble(9));
				
				CompanyprofitList.add(companyprofit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(CompanyprofitList.isEmpty()) {
			return null;
		}
		else {
			return CompanyprofitList;
		}
	}

	@Override
	public List<Companyprofit> selectCompanyprofit(String sql, String[] param) {
		List<Companyprofit> CompanyprofitList = new ArrayList<Companyprofit>();
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
				Companyprofit companyprofit = new Companyprofit();
				companyprofit.setYear(rs.getInt(1));
				companyprofit.setMonth(rs.getInt(2));
				companyprofit.setRep_cost(rs.getDouble(3));
				companyprofit.setSalary_standard(rs.getDouble(4));
				companyprofit.setSalary_cost(rs.getDouble(5));
				companyprofit.setOther_cost(rs.getDouble(6));
				companyprofit.setOrder_income(rs.getDouble(7));
				companyprofit.setOther_income(rs.getDouble(8));
				companyprofit.setTotal_profit(rs.getDouble(9));
				
				CompanyprofitList.add(companyprofit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(CompanyprofitList.isEmpty()) {
			return null;
		}
		else {
			return CompanyprofitList;
		}
	}

	@Override
	public int updateCompanyprofit(String sql, String[] param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
