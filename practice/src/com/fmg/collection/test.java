package com.fmg.collection;

public class test {

	public static void main(String[] args) {
		
		//穿衣服
		String a = "";
		a = chuanyifu();
		
		//穿鞋
		if("chuanShang".equalsIgnoreCase(a)){
			chuanxie();
			
			//开门
			int status = 0;
			status = kaimen();
			
			//锁门
			if(status==1){
				guanmen();
			}else{
				System.out.println("你门还没关呢，开什么开！！！");
			}
		}else{
			System.out.println("没穿衣服");
		}
		
		
	}

	private static void guanmen() {
		System.out.println("关门");
		
	}

	private static int kaimen() {
		System.out.println("开门");	
		return 1;
	}

	private static void chuanxie() {
		System.out.println("穿鞋");
	}

	private static String chuanyifu() {
		System.out.println("穿衣服");
		return "chuanshang";
	}

}
