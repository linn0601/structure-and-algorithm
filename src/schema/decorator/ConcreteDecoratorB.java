package schema.decorator;

public class ConcreteDecoratorB extends Decorator {

	@Override
	public void operation() {
		super.operation();

		System.out.println("调用装饰对象b的功能");

	}
}
