package com.fmg.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bufferWriterDemo {

	public static void main(String args[]){
		try {
			run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void run() throws IOException {
		FileWriter fw = new FileWriter("abc.txt");
		
		BufferedWriter bf = new BufferedWriter(fw);
		
		
		for (int i = 1; i < 4; i++) {
			bf.write("你好" + i);
			bf.newLine();
			bf.flush();
		}
		
		bf.flush();
		
		fw.close();
	}
}
