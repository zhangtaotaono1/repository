package com.fmg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TransServer {

	public static void main(String args[]) throws IOException{
		server();
	}

	private static void server() throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "接入...");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		
		String line = null;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			pw.println(line.toUpperCase());
		}
		
		s.close();
		ss.close();
	}
}
