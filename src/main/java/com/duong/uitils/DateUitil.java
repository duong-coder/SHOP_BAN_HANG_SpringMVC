package com.duong.uitils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUitil {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat();
	public static Date toDate() {
		
		return null;
	}
	
	public static String toString(Date date, String pattern) {
		dateFormat.applyPattern(pattern);
		
		return dateFormat.format(date);
	}
}
