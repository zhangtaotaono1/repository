package com.fmg.test;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String args[]){
//		demo1();
//		demo2();
		
		demo3();
	}

	private static void demo3() {
		
		
	}

	private static void demo2() {
		String arr[] = {"aa","sadf","asdf"};
		
		List<String> ar = Arrays.asList(arr);
		System.out.println(ar);
		System.out.println(ar.contains("a"));
		
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	private static void demo1() {
		int arr[] = {1,3,5,7,2,7,3,3};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
	}
}
