package com.ssdut.taximanage.entity;

/*
 * @ 某月司机工资
 */
public class Salary {
	private String id;
	private int year;
	private int month;
	private int day_num;
	private double salary_standard;
	private double wage;
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay_num() {
		return day_num;
	}
	public void setDay_num(int day_num) {
		this.day_num = day_num;
	}
	public double getSalary_standard() {
		return salary_standard;
	}
	public void setSalary_standard(double salary_standard) {
		this.salary_standard = salary_standard;
	}

	
	
}
