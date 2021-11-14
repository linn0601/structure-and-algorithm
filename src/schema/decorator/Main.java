package schema.decorator;

public class Main {

	public static void main(String[] args) {

		ConcreteComponent concreteComponent = new ConcreteComponent();

		ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(); // 装饰对象A
		ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(); // 装饰对象B

		decoratorA.setComponent(concreteComponent);
		decoratorB.setComponent(concreteComponent);
	}
}
