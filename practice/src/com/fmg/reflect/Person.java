package com.fmg.reflect;

public class Person {

	private String name;
	private int age;
	
	public Person(){
		System.out.println("Person run");
	}
	
	public Person(String name, int age){
		System.out.println("Person param run..." + name + ":" + age);
	}
	
	public void show(){
		System.out.println(this.name + "...show run" + this.age);
	}
	
	private void privateMethod(){
		System.out.println("method run");
	}
	
	public void  paramMethod(String str, int num){
		System.out.println("paramMethod run..." + str + ":" + num);
	}
	
	public static void staticMethod(){
		System.out.println("staticMethod run");
	}
}
