package schema.strategy;

public class ConcreteStrategyB extends Strategy{

	@Override
	public double algorithmInterface(double money) {
		return money * 0.7;
	}
}
