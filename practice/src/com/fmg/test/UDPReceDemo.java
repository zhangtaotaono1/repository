package com.fmg.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo {

	public static void main(String args[]) throws Exception{
		rece();
	}

	private static void rece() throws Exception {
		System.out.println("接收端启动...");
		
		DatagramSocket ds = new DatagramSocket(10000);
		
		byte[] bb = new byte[1024];
		
		DatagramPacket dp = new DatagramPacket(bb, bb.length);
		
		ds.receive(dp);
		
		String ip = dp.getAddress().getHostAddress();
		System.out.println(ip);
		int port = dp.getPort();
		System.out.println(port);
		String str = new String(dp.getData(), 0, dp.getLength());
		System.out.println(ip + "..." + port + "..."+ str);
		
		ds.close();
	}
}
