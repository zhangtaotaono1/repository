
public class RunableTest implements Runnable{

	@Override
	public void run() {
		show();
		
	}
	
	void show(){
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}

}
