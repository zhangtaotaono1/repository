package com.fmg.test;

import java.util.Arrays;
import java.util.List;

public class proTest {

	public static void main(String[] args) {
		run();
	}

	private static void run() {
		//产线编号列表
		List<String> productLineNo = Arrays.asList("A", "B", "C");
		for (int i = 0; i < 1000; i ++) {
			String productLine = calProductLine(productLineNo);
			System.out.print (productLine);
		}
		
	}
	
	//实现该方法，该方法的参数就是产线列表
	public static String calProductLine(List<String> list) {
		return null;

	}

}
