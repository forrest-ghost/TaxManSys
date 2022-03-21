package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.CarinformDao;
import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.service.DatetoString;

public class CarinformDaoImpl extends BaseDao implements CarinformDao {

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	@Override
	public List<Carinform> getAllCarinform() {
		List<Carinform> carinformList = new ArrayList<Carinform>(); 
		try {
			String preparedSql = "select car_id,dept_id,onboard_time,resign_time from Carinform ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {

				Carinform carinform = new Carinform();
				carinform.setCar_id(rs.getString(1));
				carinform.setDept_id(rs.getString(2));
				carinform.setOnboard_time(DatetoString.stringtoDate(rs.getString(3)));
				carinform.setResign_time(DatetoString.stringtoDate(rs.getString(4)));
				
				carinformList.add(carinform);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(carinformList.isEmpty()) {
			return null;
		}
		else {
			return carinformList;
		}
	}

	@Override
	public Carinform selectCarinform(String sql, String[] param) {
		Carinform carinform = new Carinform();
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
				
				carinform.setCar_id(rs.getString(1));
				carinform.setDept_id(rs.getString(2));
				carinform.setOnboard_time(DatetoString.stringtoDate(rs.getString(3)));
				carinform.setResign_time(DatetoString.stringtoDate(rs.getString(4)));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(carinform.getCar_id()!=null) {
			return carinform;
		}
		else {
			return null;
		}
	}

	@Override
	public int updateCarinform(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
