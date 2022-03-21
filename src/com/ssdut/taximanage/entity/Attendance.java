package com.ssdut.taximanage.entity;

import java.util.*;
/*
 * @ ³öÇÚ¼ÇÂ¼±í
 */
public class Attendance {
	private String id;
	private String car_id;
	private Date date;
	private Date work_time;
	private Date offwork_time;
	private int workhours;
	
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getWork_time() {
		return work_time;
	}
	public void setWork_time(Date work_time) {
		this.work_time = work_time;
	}
	public Date getOffwork_time() {
		return offwork_time;
	}
	public void setOffwork_time(Date offwork_time) {
		this.offwork_time = offwork_time;
	}
	public int getWorkhours() {
		return workhours;
	}
	public void setWorkhours(int workhours) {
		this.workhours = workhours;
	}


	
	
}
