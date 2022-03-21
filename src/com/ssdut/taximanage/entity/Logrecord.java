package com.ssdut.taximanage.entity;

import java.util.*;

/*
 * @µÇÂ¼¼ÇÂ¼´æ´¢
 */
public class Logrecord {
	private String Log_id;
	private String passwd;
	private Date time;
	private String Log_ip;
	
	public String getLog_id() {
		return Log_id;
	}
	public void setLog_id(String log_id) {
		Log_id = log_id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getLog_ip() {
		return Log_ip;
	}
	public void setLog_ip(String log_ip) {
		Log_ip = log_ip;
	}

	
}
