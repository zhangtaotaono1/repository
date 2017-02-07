package com.fmg.string;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		System.out.println(sb);
		System.out.println(sb.append(4).append(5));
		System.out.println(sb.insert(0, "haha").append(9));
		System.out.println(sb);
		String s1 = "af";
		System.out.println(s1.concat("r"));
	}
	
	
}
