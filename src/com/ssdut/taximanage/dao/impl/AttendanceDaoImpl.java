package com.ssdut.taximanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssdut.taximanage.dao.AttendanceDao;
import com.ssdut.taximanage.dao.BaseDao;
import com.ssdut.taximanage.entity.Attendance;
import com.ssdut.taximanage.service.DatetoString;

public class AttendanceDaoImpl extends BaseDao implements AttendanceDao {
	private Connection conn = null; // �������ݿ�����
	private PreparedStatement pstmt = null; // ����ִ��SQL���
	private ResultSet rs = null; // �û������ѯ�����
	
	@Override
	public List<Attendance> selectAttendance(String sql, String[] param) {
		List<Attendance> attendanceList = new ArrayList<Attendance>(); 
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			rs = pstmt.executeQuery(); // ִ��SQL���
			Attendance attendance = null;
			while (rs.next()) {
				attendance = new Attendance();
				attendance.setId(rs.getString(1));//˾�����
				attendance.setCar_id(rs.getString(2));//�������
				attendance.setDate(DatetoString.stringtoDate(rs.getString(3)));//�ϰ�����
				attendance.setWork_time(DatetoString.stringtoTime(rs.getString(4)));//�ϰ�ʱ��
				attendance.setOffwork_time(DatetoString.stringtoTime(rs.getString(5)));//�°�ʱ��
				attendance.setWorkhours(rs.getInt(6));//����ʱ��
				
				attendanceList.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		if(attendanceList.isEmpty()) {
			return null;
		}
		else {
		return attendanceList;
	}
		}

	@Override
	public int updateAttendance(String sql, String[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

}
