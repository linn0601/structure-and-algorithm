package schema.strategy;

/**
 * 用一个ConcreteStrategy 来配置，维护一个对Strategy 引用
 */
public class Context {

	private Strategy strategy;

	/**
	 * 在初始化是传入具体的策略（strategy）
	 */
	public Context(String type) {// 折扣类型

		switch(type) {
			case "正常收费":
				ConcreteStrategyA strategyA = new ConcreteStrategyA();
				strategy = strategyA;
				break;
			case "打折收费":
				ConcreteStrategyB strategyB = new ConcreteStrategyB();
				strategy = strategyB;
				break;
			case "满减收费":
				ConcreteStrategyC strategyC = new ConcreteStrategyC();
				strategy = strategyC;
				break;
		}
	}

	/**
	 * 根据具体的策略对象，调用其算法的方法
	 */
	public double contextInterface(double money) {
		return strategy.algorithmInterface(money);
	}

}
