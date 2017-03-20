package com.fmg.test;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {

		// 获取日期
		System.out.println(getWeek("星期一"));
	}

	/**
	 * 
	 * @param i
	 * @return 
	 */
	private static String getWeek(String i) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("星期一", "Mon");
		map.put("星期二", "Tue");
		map.put("星期三", "Wes");
		
		return map.get(i);
	}
}
