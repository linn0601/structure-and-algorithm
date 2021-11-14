package schema.strategy;

/**
 * 策略模式，定义一个算法家族，分别封装起来，让他们之间可以相互替换，此模式让算法的变化不会影响到算法的使用。
 *
 * Strategy类 定义所有支持算法的公共接口
 */
public abstract class Strategy {

	// 算法方法
	public abstract double algorithmInterface(double money);
}
