package com.fmg.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

	public static void main(String args[]) throws UnknownHostException{
		InetAddress ip = InetAddress.getByName("www.baidu.com");
		
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		
		ip = InetAddress.getLocalHost();
		
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		
		InetAddress[] ips = InetAddress.getAllByName("www.baidu.com");
		
		for (InetAddress inetAddress : ips) {
			System.out.println("..." + inetAddress);
		}
		
		System.out.println(InetAddress.getByName("192.168.1.31"));
	}
}
