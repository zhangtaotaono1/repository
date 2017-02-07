package com.fmg.string;

public class StringDemo {

	public static void main(String[] args) {
		/*
		 * String s = "15234565"; System.out.println(s.length());
		 * System.out.println(s.charAt(3)); System.out.println(s.indexOf('5'));
		 * System.out.println(s.lastIndexOf('5'));
		 */
		// String s = "张三.李四.王五";
		// String[] arr = s.split("\\.");
		/*
		 * char[] arr = s.toCharArray(); for (int i = 0; i < arr.length; i++) {
		 * System.out.println(arr[i]); }
		 */

		/*
		 * String s1 = "abcde"; String s2 = "ab".concat("cde"); String s3 = "ab"
		 * + "cde"; System.out.println(s2 == s3);
		 * System.out.println(s1.equals(s2));
		 */

		/*
		 * String s = "abcd"; System.out.println(s.contains("cd"));
		 * System.out.println(s.indexOf("cd"));
		 * System.out.println(s.startsWith("ab"));
		 */

		/*
		 * String s1 = "abc"; String s2 = s1.intern(); String s3 = "abcd"; s1 =
		 * s3.intern();
		 * 
		 * System.out.println(s2); System.out.println(s1);
		 * System.out.println(s3);
		 */

		/*//字符串数组排序
		String[] s = { "nba", "abc", "cba", "zz", "qq", "haha" };

		printString(s);
		sortString(s);
		System.out.println();
		printString(s);*/
		
		//查找字符串出现的次数
		/*String s = "abcdafsfafagagdag";
		getCount(s, "fa");*/
		
		 String s = "15234565";
		 System.out.println(s.charAt(1));
	}

	/**
	 * 查找字符串出现次数
	 * @param s
	 * @param str 
	 */
	private static void getCount(String s, String str) {
		int count = 0;
		int index = 0;
		
		while((index = s.indexOf(str)) != -1){
			s = s.substring(index + str.length());
			System.out.println("s==" + s);
			count++;
		}
		System.out.println(count);
	}

	/**
	 * 数组排序
	 * 
	 * @param s
	 */
	private static void sortString(String[] s) {

		for (int i = 0; i < s.length - 1; i++) {
			for (int j = i + 1; j < s.length; j++) {
				if(s[i].compareTo(s[j]) > 0){
					swap(s, i, j);
				}
			}
		}
	}

	private static void swap(String[] s, int i, int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	/**
	 * 打印数组
	 * 
	 * @param s
	 */
	private static void printString(String[] s) {
		System.out.print("[");
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) {
				System.out.print(s[i] + "]");
			} else {
				System.out.print(s[i] + ",");
			}
		}

	}
}
