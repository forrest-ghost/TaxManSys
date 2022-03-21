package com.ssdut.taximanage.entity;

import java.util.*;
/*
 * @ ¶©µ¥¼ÇÂ¼±í
 */
public class Ordrecord {
	private String order_id;
	private String id;
	private String car_id;
	private Date order_time;
	private double cost;
	private double Journey;
	
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getJourney() {
		return Journey;
	}
	public void setJourney(double journey) {
		Journey = journey;
	}

	
	
}
