
public class UseMouse implements USB{

	@Override
	public void open() {
		System.out.println("open mouse");
	}

	@Override
	public void close() {
		System.out.println("close mouse");
	}

}
