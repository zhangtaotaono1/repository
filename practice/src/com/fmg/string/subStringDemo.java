package com.fmg.string;

public class subStringDemo {

	public static void main(String[] args) {
		String s = "     ag s se  ";
		System.out.println(subString(s));
	}

	private static String subString(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start <= end && s.charAt(start) == ' ') {
			start++;
		}

		while (start <= end && s.charAt(end) == ' ') {
			end--;
		}

		return s.substring(start, end + 1);
	}
}
