package com.fmg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TransStreamDemo {

	public static void main(String args[]) throws IOException{
		InputStream si = System.in;
		
		InputStreamReader ist = new InputStreamReader(si);
		
		BufferedReader br = new BufferedReader(ist);
		
		String line = null;
		while((line = br.readLine()) != null){
			if("over".equals(line)){
				break;
			}
			System.out.println(line.toUpperCase());
		}
	}
}
