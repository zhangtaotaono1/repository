package com.fmg.io;

public class PersonDemo {

	public static void main(String args[]){
		Person p = new Person();
		Person1 p1 = new Person1(p);
		p1.chifan();
		
		System.out.println("==========");
		
		Person2 p2 = new Person2();
		p2.chifan();
	}
}
