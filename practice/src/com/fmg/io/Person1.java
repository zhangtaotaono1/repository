package com.fmg.io;

public class Person1 {

	private Person p;
	
	Person1(Person p){
		this.p = p;
	}
	
	public void chifan(){
		System.out.println("开胃酒");
		p.chifan();
		System.out.println("甜点");
	}
}
