package com.fmg.thread;

public class test {

	public static void main(String[] args) {
		//创建资源
		Resource r = new Resource();
		//创建任务
		Input in = new Input(r);
		Output out = new Output(r);
		//创建线程，执行路径
		Thread r1 = new Thread(in);
		Thread r2 = new Thread(out);
		//开始线程
		r1.start();
		r2.start();
	}
}
