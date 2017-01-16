
public class Zi extends Fu{
	
	private int num = 99;
	
	{
		System.out.println("Zi");
	}
	
	Zi(){
		super();
		
		show();
	}
	
	void show(){
		System.out.println("Zi..." + num);
	}
	
	public static void main(String[] args) {
		new Zi();
	}
}
