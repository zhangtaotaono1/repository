package com.fmg.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceTest {

	public static void main(String args[]) throws IOException{
		rece();
	}

	/**
	 * 接收请求的数据
	 * @throws IOException 
	 */
	private static void rece() throws IOException {
		System.out.println("数据接收器启动...");
		
		
		DatagramSocket ds = new DatagramSocket(7777);
		
		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			
			ds.receive(dp);
			
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(), 0, dp.getLength());
			
			/*if(text.equals("886")){
				ds.close();
			}*/
			
			System.out.println(ip + ":" + port + "...接收到的信息：" + text);
			
		}
	}
}
