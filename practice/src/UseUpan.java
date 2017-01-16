
public class UseUpan implements USB{

	@Override
	public void open() {
		System.out.println("open upan");
	}

	@Override
	public void close() {
		System.out.println("close upan");
	}

}
