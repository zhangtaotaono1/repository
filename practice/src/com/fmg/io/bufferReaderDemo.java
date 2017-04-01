package com.fmg.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class bufferReaderDemo {

	public static void main(String args[]){
		try {
			run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void run() throws IOException {
		FileReader fr = new FileReader("abc.txt");
		
		BufferedReader bf = new BufferedReader(fr);
		
		LineNumberReader ln = new LineNumberReader(bf);
		
		String str = null;
		
		ln.setLineNumber(100);
		while ((str = ln.readLine()) != null) {
//			System.out.println(str);
			System.out.println(ln.getLineNumber() + ":" + str);
		}
		
		/*int ch = 0;
		
		while ((ch = bf.read()) != -1) {
			System.out.print((char)ch);
		}*/
		
		bf.close();
		fr.close();
	}
}
