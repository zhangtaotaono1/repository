
/**
 * 
 * @ClassName: Demo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Feng Maogen 
 * @date 2017年3月21日 下午9:42:55 
 *
 */
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
