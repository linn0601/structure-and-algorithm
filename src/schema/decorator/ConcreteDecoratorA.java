package schema.decorator;

/**
 * 装饰类的功能1
 */
public class ConcreteDecoratorA extends Decorator {

	private String addedState;

	@Override
	public void operation() {
		super.operation();
		addedState = "调用装饰对象a的功能";

		System.out.println(addedState);
	}
}
