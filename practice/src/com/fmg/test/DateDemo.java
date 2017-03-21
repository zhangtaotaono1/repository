package com.fmg.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

	public static void main(String args[]){
//		run();
//		run1();
//		run2();
		/*try {
			sub();
		} catch (Exception e) {
		e.printStackTrace();
		}*/
//		caleTest();
		caleTest1();
	}

	/**
	 * 写出2017年2月有多少天
	 */
	private static void caleTest1() {
		int year = 2017;
		show(year);
		
	}

	private static void show(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, 2, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		
		int year1 = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year1 + "-" + month + "-" + day);
	}

	private static void caleTest() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(year + "-" + month + "-" + dayOfMonth);
		
		String str[] = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}; 
		System.out.println(str[dayOfWeek]);
		
	}

	private static void sub() throws Exception {
		String number1 = "2017-3-17";
		String number2 = "2017-4-6";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long date1 = df.parse(number1).getTime();
		long date2 = df.parse(number2).getTime();
		System.out.println(Math.abs(date2 - date1));
		System.out.println(Math.abs(date1 - date2)/1000/60/60/24);
	}

	private static void run2() {
		String str_date1 = "2017年3月20日";
		String str_date2 = "2017-3-20 10:42:12";
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		try {
			System.out.println(df.parse(str_date1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println(df.parse(str_date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void run1() {
		Date date = new Date();
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String dateStr = df.format(date);
		System.out.println(dateStr);
		
		df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.LONG);
		dateStr = df.format(date);
		System.out.println(dateStr);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateStr = sdf.format(date);
		System.out.println(dateStr);
		
	}

	private static void run() {

		long date = System.currentTimeMillis();
		System.out.println(date);
		
		Date date1 = new Date();
		System.out.println(date1);
		
		Date date2 = new Date(date);
		System.out.println(date2);
	}
}
