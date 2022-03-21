package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.dao.UsermanageDao;
import com.ssdut.taximanage.entity.Usermanage;

public class UsermanageDaoImpl extends BaseDao implements UsermanageDao {

	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	@Override
	public List<Usermanage> getAllUsermanage() {
		List<Usermanage> usermanageList = new ArrayList<Usermanage>();
		try {
			String preparedSql = "select user,passwd,status,level from Usermanage ";
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���

			while (rs.next()) {

				Usermanage usermanage = new Usermanage();
				usermanage.setUser(rs.getString(1));
				usermanage.setPasswd(rs.getString(2));
				usermanage.setStatus(rs.getString(3));
				usermanage.setLevel(rs.getInt(4));

				usermanageList.add(usermanage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(usermanageList.isEmpty()) {
			return null;
		}
		else {
		return usermanageList;
				}
	}
	@Override
	public Usermanage selectUsermanage(String sql, String[] param) {
		Usermanage usermanage = new Usermanage();
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
				
				usermanage.setUser(rs.getString(1));
				usermanage.setPasswd(rs.getString(2));
				usermanage.setStatus(rs.getString(3));
				usermanage.setLevel(rs.getInt(4));

				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(usermanage.getUser()!=null) {
			return usermanage;
		}
		else {
			return null;
		}
	}

	@Override
	public int updateUsermanage(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
