
public class Fu {
	
	private int num = 10;
	
	{
		System.out.println("Fu ");
	}
	
	Fu(){
		super();
		
		show();
	}
	
	void show(){
		System.out.println("Fu..." + num);
	}
}
