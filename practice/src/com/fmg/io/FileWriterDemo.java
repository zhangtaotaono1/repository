package com.fmg.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String args[]){
//		writer();
		try {
			read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void read() throws Exception {
		FileReader rd = new FileReader("C:\\Users\\Administrator\\Desktop\\abc.txt");
		
		int ch = 0;
		
		while ((ch = rd.read()) != -1) {
			System.out.print((char)ch);
		}
	}

	private static void writer() {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\abc.txt", true);
//			fw.write("别紧张，我不是好人！");
			fw.write("嘿嘿");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		// TODO Auto-generated method stub
		
	}
}
