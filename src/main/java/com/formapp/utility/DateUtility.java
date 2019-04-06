package com.formapp.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateUtility {
	private static int counter = 0;
	private static Date newDate = new Date();
	
	public static String dateToJulian(Date date) {
		StringBuilder sb = new StringBuilder();
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(date);
		int day = calDate.get(Calendar.DAY_OF_YEAR);
		return sb.append(String.format("%03d", day)).toString();
	}

	public static String getCounter(Date date) {
		StringBuilder sb = new StringBuilder();
		if (formatDate(date).compareTo(formatDate(newDate)) == 0) {
			System.out.println(" counter if " + newDate);
			counter++;
			return sb.append(String.format("%03d", counter)).toString();

		} else {
			System.out.println(" counter else");
			newDate = date;
			counter = 1;
			return sb.append(String.format("%03d", counter)).toString();
		}

	}

	public static Date formatDate(Date date) {
		Date tempDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		try {
			tempDate = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempDate;
	}
}
