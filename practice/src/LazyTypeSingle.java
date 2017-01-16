
public class LazyTypeSingle {

	private LazyTypeSingle(){
		
	}
	
	private static LazyTypeSingle lt = null;
	
	public static LazyTypeSingle getInstance(){
		if(lt == null){
			lt = new LazyTypeSingle();
		}
		return lt;
	}
}
