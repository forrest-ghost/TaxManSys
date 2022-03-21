package com.ssdut.taximanage.entity;
/*
 * 公司月盈利表
 */
public class Companyprofit {
	private int year;
	private int month;
	private double rep_cost;
	private double salary_standard;
	private double salary_cost;
	private double other_cost;
	private double order_income;
	private double other_income;
	private double total_profit;
	
	
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
	public double getRep_cost() {
		return rep_cost;
	}
	public void setRep_cost(double rep_cost) {
		this.rep_cost = rep_cost;
	}
	public double getSalary_standard() {
		return salary_standard;
	}
	public void setSalary_standard(double salary_standard) {
		this.salary_standard = salary_standard;
	}
	public double getSalary_cost() {
		return salary_cost;
	}
	public void setSalary_cost(double salary_cost) {
		this.salary_cost = salary_cost;
	}
	public double getOther_cost() {
		return other_cost;
	}
	public void setOther_cost(double other_cost) {
		this.other_cost = other_cost;
	}
	public double getOrder_income() {
		return order_income;
	}
	public void setOrder_income(double order_income) {
		this.order_income = order_income;
	}
	public double getOther_income() {
		return other_income;
	}
	public void setOther_income(double other_income) {
		this.other_income = other_income;
	}
	public double getTotal_profit() {
		return total_profit;
	}
	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
	}

	
	
}
