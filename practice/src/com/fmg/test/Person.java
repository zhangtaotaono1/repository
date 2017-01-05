package com.fmg.test;

public class Person {
	
	private int age;
	private String name;

	Person(){
		System.out.println("print Person");
	}
	
	Person(int age){
		System.out.println("有参函数");
	}
	
	public void speak(){
		System.out.println(name + ":" + age);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
