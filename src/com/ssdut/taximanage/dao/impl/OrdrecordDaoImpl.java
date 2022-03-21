package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.OrdrecordDao;
import com.ssdut.taximanage.entity.Ordrecord;
import com.ssdut.taximanage.service.DatetoString;

public class OrdrecordDaoImpl extends BaseDao implements OrdrecordDao {

	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	@Override
	public List<Ordrecord> selectOrdrecord(String sql, String[] param) {
		List<Ordrecord> OrdrecordList = new ArrayList<Ordrecord>();
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
				Ordrecord ordrecord = new Ordrecord();
				ordrecord.setOrder_id(rs.getString(1));
				ordrecord.setId(rs.getString(2));
				ordrecord.setCar_id(rs.getString(3));
				ordrecord.setOrder_time(DatetoString.stringtoDateTime(rs.getString(4)));
				ordrecord.setCost(rs.getDouble(5));
				ordrecord.setJourney(rs.getDouble(6));
				
				OrdrecordList.add(ordrecord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(OrdrecordList.isEmpty()) {
			return null;
		}
		else {
			return OrdrecordList;
		}
	}

	@Override
	public int updateOrdrecord(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
