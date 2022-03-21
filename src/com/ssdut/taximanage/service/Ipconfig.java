package com.ssdut.taximanage.service;

import java.net.InetAddress;
public class Ipconfig {
	public static String getIP()    {
	      try {
	    	  InetAddress addr = InetAddress.getLocalHost();
		      return addr.getHostAddress();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
		return "null";
	   }
}
