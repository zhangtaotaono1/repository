package com.fmg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TransClient {

	public static void main(String args[]) throws IOException{
		send();
	}

	private static void send() throws IOException {
		
		System.out.println("客户端启动");
		Socket s = new Socket("192.168.1.102", 8888);
		
		BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		
		BufferedReader brin = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String line = null;
		while ((line = bri.readLine()) != null) {
			if("over".equals(line)){
				break;
			}
			pw.println(line);
			
			String str = brin.readLine();
			System.out.println(str);
		}
		s.close();
		
	}
}
