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
	private Connection conn = null; // 保存数据库连接
	private PreparedStatement pstmt = null; // 用于执行SQL语句
	private ResultSet rs = null; // 用户保存查询结果集
	
	@Override
	public List<Attendance> selectAttendance(String sql, String[] param) {
		List<Attendance> attendanceList = new ArrayList<Attendance>(); 
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setString(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			rs = pstmt.executeQuery(); // 执行SQL语句
			Attendance attendance = null;
			while (rs.next()) {
				attendance = new Attendance();
				attendance.setId(rs.getString(1));//司机编号
				attendance.setCar_id(rs.getString(2));//车辆编号
				attendance.setDate(DatetoString.stringtoDate(rs.getString(3)));//上班日期
				attendance.setWork_time(DatetoString.stringtoTime(rs.getString(4)));//上班时间
				attendance.setOffwork_time(DatetoString.stringtoTime(rs.getString(5)));//下班时间
				attendance.setWorkhours(rs.getInt(6));//工作时长
				
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
