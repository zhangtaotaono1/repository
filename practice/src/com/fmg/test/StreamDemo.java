package com.fmg.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamDemo {

	public static void main(String args[]) throws IOException{
		in();
//		out();
	}

	private static void in() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt")));
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		while((line = br.readLine()) != null){
			if("over".equals(line)){
				break;
			}
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	private static void out() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("abc.txt", true)));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			if("\r".equals(line)){
				continue;
			}
			if("over".equals(line)){
				break;
			}
			System.out.println(line.toUpperCase());
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
