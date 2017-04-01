package com.fmg.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	public static void main(String args[]){
		run();
	}

	private static void run() {
		FileReader rd = null;
		FileWriter fw = null;
		try {
			rd = new FileReader("demo.txt");
			fw = new FileWriter("abc.txt");
			
			int ch = 0;
			
			char[] len = new char[1024];
			
			while ((ch = rd.read(len)) != -1) {
				fw.write(len, 0, ch);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
