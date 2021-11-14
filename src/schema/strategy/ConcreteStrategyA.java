package schema.strategy;

/**
 * 具体的算法，继承Strategy
 */
public class ConcreteStrategyA extends Strategy {

	@Override
	public double algorithmInterface(double money) {
		return money * 0.8;
	}
}
