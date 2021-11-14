package schema.strategy;

public class ConcreteStrategyC extends Strategy {

	@Override
	public double algorithmInterface(double money) {
		return money * 0.3;
	}
}
