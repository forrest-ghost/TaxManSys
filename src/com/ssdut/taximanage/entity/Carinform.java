package com.ssdut.taximanage.entity;

import java.util.*;
/*
 * @ 车辆信息表
 */

public class Carinform {
	private String car_id;
	private String dept_id;
	private Date onboard_time;
	private Date resign_time;
	
	
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public Date getOnboard_time() {
		return onboard_time;
	}
	public void setOnboard_time(Date onboard_time) {
		this.onboard_time = onboard_time;
	}
	public Date getResign_time() {
		return resign_time;
	}
	public void setResign_time(Date resign_time) {
		this.resign_time = resign_time;
	}
	
	
}
