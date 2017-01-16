
public class Demo extends Thread{
	
	
	private String name;
	
	Demo(String name){
		this.name = name;
	}

	public void run(){
		for (int i = 0; i < 10; i++) {
			System.out.println(name + "...x = " + i + "ThreadName..." + Thread.currentThread().getName());
		}
	}
}
