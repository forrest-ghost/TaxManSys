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

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	@Override
	public List<Carreprecords> selectCarreprecords(String sql, String[] param) {
		List<Carreprecords> carreprecordsList = new ArrayList<Carreprecords>();
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
