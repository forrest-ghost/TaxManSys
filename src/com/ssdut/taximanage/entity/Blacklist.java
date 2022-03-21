package com.ssdut.taximanage.entity;

import java.util.*;
/*
 * @µÇÂ¼ºÚÃûµ¥
 */
public class Blacklist {
	private String ip_address;
	private Date login_time;
	
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public Date getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	
	
}
