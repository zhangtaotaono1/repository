package com.fmg.test;

public class Person {
	{
		System.out.println("我是代码块");
	}
	Person(){
		System.out.println("我是构造函数");
	}
	
	public void show(){
		System.out.println("大家好");
	}
	
	public static void print(){
		System.out.println("打印静态方法");
	}
	static{
		System.out.println("我是静态代码块");
		
	}
}
