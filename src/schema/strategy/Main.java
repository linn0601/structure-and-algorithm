package schema.strategy;

public class Main {

	// 客户端代码
	public static void main(String[] args) {

		// in  => args[0] = "打折收费";
		Context context = new Context("打折收费");

		// 执行指定策略的算法逻辑
		double result = context.contextInterface(100);

		System.out.println(result);
	}
}
