package com.fmg.test;

public class EncodeTest {

	public static void main(String args[]) throws Exception{
		String str = "你好";
		
		//编码
		byte[] str1 = str.getBytes("gbk");
		printByte(str1);
		
		byte[] str2 = str.getBytes("utf-8");
		printByte(str2);
		
		//解码
		String str11 = new String(str1, "gbk");
		System.out.println(str11);

		String str22 = new String(str2);
		System.out.println(str22);
		
	}

	private static void printByte(byte[] str1) {
		for (byte b : str1) {
			System.out.print(b + " ");
		}
		System.out.println();
	}
}
