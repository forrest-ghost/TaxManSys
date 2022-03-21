package com.ssdut.taximanage.entity;

import java.util.*;
/*
 * @³µÁ¾Î¬ÐÞ¼ÇÂ¼
 */
public class Carreprecords {
	private String record_id;
	private String car_id;
	private Date repsta_date;
	private Date repcom_date;
	private double rep_fees;
	
	public String getRecord_id() {
		return record_id;
	}
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public Date getRepsta_date() {
		return repsta_date;
	}
	public void setRepsta_date(Date repsta_date) {
		this.repsta_date = repsta_date;
	}
	public Date getRepcom_date() {
		return repcom_date;
	}
	public void setRepcom_date(Date repcom_date) {
		this.repcom_date = repcom_date;
	}
	public double getRep_fees() {
		return rep_fees;
	}
	public void setRep_fees(double rep_fees) {
		this.rep_fees = rep_fees;
	}

	
}
