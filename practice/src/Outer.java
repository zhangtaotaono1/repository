
public class Outer {
/*	private int num = 7;
	
	class Inner{
		void show(){
			System.out.println("inner....num = " + num);
		}
	}
	
	void method(){
		Inner i = new Inner();
		i.show();
	}*/
	int num = 3;
	
	void show(final int y){
		class Inner{
			void show(){
				System.out.println("num..." + num + "y.." + y);
			}
		}
		
		Inner i = new Inner();
		i.show();
	}
}
