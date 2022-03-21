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

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	@Override
	public List<Ordrecord> selectOrdrecord(String sql, String[] param) {
		List<Ordrecord> OrdrecordList = new ArrayList<Ordrecord>();
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
