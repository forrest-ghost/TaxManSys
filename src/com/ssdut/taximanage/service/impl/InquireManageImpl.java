package com.ssdut.taximanage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.ssdut.taximanage.dao.AttendanceDao;
import com.ssdut.taximanage.dao.CarinformDao;
import com.ssdut.taximanage.dao.PerinformDao;
import com.ssdut.taximanage.dao.impl.AttendanceDaoImpl;
import com.ssdut.taximanage.dao.impl.CarinformDaoImpl;
import com.ssdut.taximanage.dao.impl.PerinformDaoImpl;
import com.ssdut.taximanage.entity.Attendance;
import com.ssdut.taximanage.entity.Carinform;
import com.ssdut.taximanage.entity.Perinform;
import com.ssdut.taximanage.service.DatetoString;
import com.ssdut.taximanage.service.InquireManage;

public class InquireManageImpl implements InquireManage {

	@Override
	public List<Carinform> getCarinform(String taxName) {
		PerinformDao perinformDao = new PerinformDaoImpl();
		String sql = "select * from Perinform where name=?";
		String[] param = {taxName};
		Perinform perinform = perinformDao.selectPerinform(sql, param);
		if(perinform!=null)
		{
			String id = perinform.getId();
			AttendanceDao attendanceDao = new AttendanceDaoImpl();
			String sql1 = "select * from Attendance where id=?";
			String[] param1= {id}; 
			List<Attendance> attendanceList = new ArrayList<Attendance>();
			attendanceList = attendanceDao.selectAttendance(sql1, param1);
			if(attendanceList!=null)
			{
				List<String> car_idList = new ArrayList<String>();
				for(int i=0;i<attendanceList.size();i++)
				{
					String carid = attendanceList.get(i).getCar_id();
					if(!car_idList.contains(carid)) {
						car_idList.add(carid);
					}
				}
				CarinformDao carinformDao = new CarinformDaoImpl();
				List<Carinform> carinformList = new ArrayList<Carinform>();
				String sql2 = "select * from Carinform where car_id=?";
				for(int i=0;i<car_idList.size();i++) {
					String[] param2= {car_idList.get(i)};
					Carinform carinform = carinformDao.selectCarinform(sql2, param2);
					if(carinform!=null) {
						carinformList.add(carinform);
					}
				}
				return carinformList;
			}
			System.out.println("没有该员工出勤信息,请联系管理员更新出勤信息");
		}
		System.out.println("员工信息表没有该员工信息，请联系管理员更新员工信息表");
		return null;
	}
	
	@Override
	public List<Perinform> getPerinform(Date date) {
		String datefind = DatetoString.datetoString(date);
		List<Perinform> perinformList = new ArrayList<Perinform>();
		PerinformDao perinformDao = new PerinformDaoImpl();
		String sql1 = "select * from Perinform where id=?";
		AttendanceDao attendanceDao = new AttendanceDaoImpl();
		List<Attendance> attendanceList = new ArrayList<Attendance>();
		String sql = "select * from Attendance where date=?";
		String[] param= {datefind};
		attendanceList = attendanceDao.selectAttendance(sql, param);
		if(attendanceList!=null) {
			for(int i=0;i<attendanceList.size();i++)
			{
				String id = attendanceList.get(i).getId();
				String[] param1 = {id};
				Perinform perinform = perinformDao.selectPerinform(sql1, param1);
				if(perinform!=null) {
					perinformList.add(perinform);
				}
			}
			return perinformList;
		}
		else {
		return null;
		}
	}
}
