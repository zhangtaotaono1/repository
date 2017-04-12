package com.fmg.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSendDemo {

	public static void main(String args[]) throws Exception{
		send();
	}

	private static void send() throws SocketException, Exception {
		
		System.out.println("发送端启动...");
		
		DatagramSocket ds = new DatagramSocket(8888);
		
		String str = "udp演示：哥们要来了!";
		
		byte[] buf = str.getBytes();
		
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.31"), 10000);
		
		ds.send(dp);
		
		ds.close();
	}
}
