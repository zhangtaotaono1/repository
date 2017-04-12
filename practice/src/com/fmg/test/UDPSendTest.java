package com.fmg.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendTest {

	public static void main(String args[]) throws IOException{
		send();
	}

	/**
	 *多次发送信息 
	 * @throws IOException 
	 */
	private static void send() throws IOException {
		System.out.println("请求端启动...");
		
		DatagramSocket ds = new DatagramSocket(6666);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		while((line = br.readLine()) != null){
			byte[] sendMsg = line.getBytes();
			
			DatagramPacket dp = new DatagramPacket(sendMsg, sendMsg.length, InetAddress.getLocalHost(), 7777);
			
			ds.send(dp);
			
			if("886".equals(line)){
				break;
			}
		}
		
		ds.close();
	}
}
