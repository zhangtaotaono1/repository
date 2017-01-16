package com.fmg.thread;

public class Resource {
	private String name;
	private String sex;
	private boolean falg;
	
	public synchronized void set(String name, String sex){
		if(falg){
			try {
				this.wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		falg = true;
		this.notify();
	}
	
	public synchronized void out(){
		if(!falg){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(name + "..." + sex);
		falg = false;
		this.notify();
	}
}
