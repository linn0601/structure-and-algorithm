package schema.builder;

/**
 * 建造者，实现了Builder 具体化复杂对象的创建
 */
public class ConcreteBuilder extends Builder{

	private final Product product = new Product();

	@Override
	public void builderPartA() {
		product.add("部件A");
	}

	@Override
	public void builderPartB() {
		product.add("部件B");
	}

	@Override
	public Product getResult() {
		return product;
	}
}
