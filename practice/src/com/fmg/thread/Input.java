package com.fmg.thread;

public class Input implements Runnable {

	Resource r;

	Input(Resource r) {
		this.r = r;
	}

	@Override
	public void run() {
		int x = 0;
		while (true) {
			if (x == 0) {
				r.set("mike", "男");
			} else {
				r.set("lili", "女");
			}
			x = (x + 1) % 2;
		}
	}

}
