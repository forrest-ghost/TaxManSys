package com.ssdut.taximanage.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetoString {
	/*
	 * ת��Ϊ����ʱ��
	 */
	public static Date stringtoDateTime(String datetime){
		SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date2=new Date();
		try {
			date2 = format2.parse(datetime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���ַ���ת��������ʱ��
        return date2;
	}
	
	/*
	 * ת��������
	 */
	public static Date stringtoDate(String date){
		SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        Date date2=new Date();
		try {
			date2 = format2.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���ַ���ת��������
        return date2;
	}
	
	/*
	 * ת��Ϊʱ��
	 */
	public static Date stringtoTime(String time){
		SimpleDateFormat format2=new SimpleDateFormat("HH:mm");
        Date date2=new Date();
		try {
			date2 = format2.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//���ַ���ת����ʱ��
        return date2;
	}
	
	/*
	 * ����ʱ�䵽�ַ���
	 */
	public static String datetimetoString(Date datetime) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time1=format.format(datetime);//��ʱ��ת�����ַ���
        return time1;
	}
	
	/*
	 * ���ڵ��ַ���
	 */
	public static String datetoString(Date date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date1=format.format(date);//��ʱ��ת�����ַ���
        return date1;
	}
	
	/*
	 * ʱ�䵽�ַ���
	 */
	public static String timetoString(Date time) {
		SimpleDateFormat format=new SimpleDateFormat("HH:mm");
        String time2=format.format(time);//��ʱ��ת�����ַ���
        return time2;
	}
	
	/*
	 * ȡ��ʱ�䵽�����
	 */
	public static int datetoYear(Date date) {

		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
 
		return Integer.parseInt(strNow1[0]);			//��ȡ��



	}
	/*
	 * ȡ��ʱ����·�
	 */
	public static int datetoMonth(Date date) {
		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
		return Integer.parseInt(strNow1[1]);			//��ȡ��
	}
	
	/*
	 * ȡ��ʱ�������
	 */
	public static int datetoDay(Date date) {
		String[] strNow1 = new SimpleDateFormat("yyyy-MM-dd").format(date).toString().split("-");
		return Integer.parseInt(strNow1[2]);			//��ȡ��
	}
}
