
public class Single {

	private static Single s = new Single();
	/**
	 * 
	 */
	private Single() {
		// TODO Auto-generated constructor stub
	}
	
	public static Single getInstance(){
		return s;
	}
	
}
