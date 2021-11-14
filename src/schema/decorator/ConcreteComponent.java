package schema.decorator;

/**
 * 具体的对象
 */
public class ConcreteComponent implements Component{

	@Override
	public void operation() {
		System.out.println("具体操作的对象");
	}
}
