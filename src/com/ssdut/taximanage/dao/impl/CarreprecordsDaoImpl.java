	package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.CarreprecordsDao;
import com.ssdut.taximanage.entity.Carreprecords;
import com.ssdut.taximanage.service.DatetoString;

public class CarreprecordsDaoImpl extends BaseDao implements CarreprecordsDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Carreprecords> selectCarreprecords(String sql, String[] param) {
		List<Carreprecords> carreprecordsList = new ArrayList<Carreprecords>();
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
				Carreprecords carreprecords = new Carreprecords();
				carreprecords.setRecord_id(rs.getString(1));
				carreprecords.setCar_id(rs.getString(2));
				carreprecords.setRepsta_date(DatetoString.stringtoDate(rs.getString(3)));
				carreprecords.setRepcom_date(DatetoString.stringtoDate(rs.getString(4)));
				carreprecords.setRep_fees(rs.getDouble(5));
				
				carreprecordsList.add(carreprecords);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(carreprecordsList.isEmpty()) {
			return null;
		}
		else {
			return carreprecordsList;
		}
	}

	@Override
	public int updateCarreprecords(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
