package com.ssdut.taximanage.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetoString {
	/*
	 * 转换为具体时间
	 */
	public static Date stringtoDateTime(String datetime){
		SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date2=new Date();
		try {
			date2 = format2.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//将字符串转换成日期时间
        return date2;
	}
	
	/*
	 * 转换成日期
	 */
	public static Date stringtoDate(String date){
		SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        Date date2=new Date();
		try {
			date2 = format2.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//将字符串转换成日期
        return date2;
	}
	
	/*
	 * 转换为时间
	 */
	public static Date stringtoTime(String time){
		SimpleDateFormat format2=new SimpleDateFormat("HH:mm");
        Date date2=new Date();
		try {
			date2 = format2.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//将字符串转换成时间
        return date2;
	}
	
	/*
	 * 具体时间到字符串
	 */
	public static String datetimetoString(Date datetime) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time1=format.format(datetime);//将时间转换成字符串
        return time1;
	}
	
	/*
	 * 日期到字符串
	 */
	public static String datetoString(Date date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date1=format.format(date);//将时间转换成字符串
        return date1;
	}
	
	/*
	 * 时间到字符串
	 */
	public static String timetoString(Date time) {
		SimpleDateFormat format=new SimpleDateFormat("HH:mm");
        String time2=format.format(time);//将时间转换成字符串
        return time2;
	}
	
	/*
	 * 取出时间到的年份
	 */
	public static int datetoYear(Date date) {

		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
 
		return Integer.parseInt(strNow1[0]);			//获取年



	}
	/*
	 * 取出时间的月份
	 */
	public static int datetoMonth(Date date) {
		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
		return Integer.parseInt(strNow1[1]);			//获取月
	}
	
	/*
	 * 取出时间的日期
	 */
	public static int datetoDay(Date date) {
		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
		return Integer.parseInt(strNow1[2]);			//获取日
	}
}
