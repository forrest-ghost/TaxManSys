package com.ssdut.taximanage.dao;

import java.util.List;
import com.ssdut.taximanage.entity.Attendance;

public interface AttendanceDao {
	/*
	 * ������֪Ա����Ϣ��ѯԱ�����ڼ�¼
	 */
	public  List<Attendance> selectAttendance(String sql, String[] param);
	
	/*
	 * ����Ա�����ڼ�¼
	 */
	public int updateAttendance(String sql, String[] param);
}
