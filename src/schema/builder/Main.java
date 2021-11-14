package schema.builder;

public class Main {

	public static void main(String[] args) {
		Director director = new Director();

		// 具体的建造者
		ConcreteBuilder builder = new ConcreteBuilder();

		// 建造对象
		director.construct(builder);

		// 获取产品
		Product product = builder.getResult();

		product.show();

	}
}
