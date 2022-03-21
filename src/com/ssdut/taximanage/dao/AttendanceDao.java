package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Attendance;

public interface AttendanceDao {
	/*
	 * 根据已知员工信息查询员工出勤记录
	 */
	public  List<Attendance> selectAttendance(String sql, String[] param);
	
	/*
	 * 更新员工出勤记录
	 */
	public int updateAttendance(String sql, String[] param);
}
