package com.fmg.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String args[]) throws Exception{
		getClassObj_1();
		System.out.println("----------------------");
		getClassObj_2();
		System.out.println("----------------------");
		getClassObj_3();
		System.out.println("----------------------");
		/*getClassObj_4();
		System.out.println("----------------------");
		getClassObj_5();
		System.out.println("----------------------");*/
//		getFieldDemo();
	}

	private static void getFieldDemo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String clazzName = "com.fmg.reflect.Person";
		
		Class<?> clazz = Class.forName(clazzName);
		
		Field field = clazz.getDeclaredField("age");
		field.setAccessible(true); //暴力访问
		Object obj = clazz.newInstance();
		field.set(obj, 20);
		Object o = field.get(obj);
		System.out.println(field);
		System.out.println(o);
	}

	private static void getClassObj_5() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String clazzName = "com.fmg.reflect.Person";
		
		Class<?> clazz = Class.forName(clazzName);
		
		Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
		
		Object obj = constructor.newInstance("冯茂根", 17);
		
	}

	private static void getClassObj_4() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String clazzName = "com.fmg.reflect.Person";
		
		Class<?> clazz = Class.forName(clazzName);
		
		Object person = clazz.newInstance();
		
	}

	private static void getClassObj_3() throws ClassNotFoundException {
		String className = "com.fmg.reflect.Person";
		Class<?> clazz = Class.forName(className);
		
		System.out.println(clazz);
	}

	private static void getClassObj_2() throws Exception {
		/*Class<Person> clazz = Person.class;
		Class<Person> clazz1 = Person.class;
		System.out.println(clazz == clazz1);*/
		
		String className = "com.fmg.reflect.Person";
		
		Class<?> clazz = Class.forName(className);
		
		Method method = clazz.getMethod("show", null);
		
		Object obj = clazz.newInstance();
		
		Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
		
		obj = constructor.newInstance("fmg", 17);
		
		method.invoke(obj, null);
	}

	private static void getClassObj_1() throws Exception {
		/*Person p = new Person();
		Class clazz = p.getClass();
		Person p1 = new Person();
		Class clazz1 = p.getClass();
		System.out.println(clazz == clazz1 );*/
		String className = "com.fmg.reflect.Person";
		
		Class<?> clazz = Class.forName(className);
		
		Method[] methods = clazz.getMethods();
		methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}
