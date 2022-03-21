package com.ssdut.taximanage.entity;

import java.util.Date;
/**
 * 
 * @author 人员信息表
 *
 */

public class Perinform {
	private String id;
	private String name;
	private String dept_id;
	private String super_id;
	private Date onboard_date;
	private Date resignation_date;
	private String onjob;
	
	public String getOnjob() {
		return onjob;
	}
	public void setOnjob(String onjob) {
		this.onjob = onjob;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getSuper_id() {
		return super_id;
	}
	public void setSuper_id(String super_id) {
		this.super_id = super_id;
	}
	public Date getOnboard_date() {
		return onboard_date;
	}
	public void setOnboard_date(Date onboard_date) {
		this.onboard_date = onboard_date;
	}
	public Date getResignation_date() {
		return resignation_date;
	}
	public void setResignation_date(Date resignation_date) {
		this.resignation_date = resignation_date;
	}

	
}
