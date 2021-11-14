package schema.proxy;

public class Main {

	/**
	 * 为其他对象提供一种代理以控制对这个对象的访问
	 */
	public static void main(String[] args) {
		SchoolGirl schoolGirl = new SchoolGirl();
		schoolGirl.setName("娇娇");

		// 追求者可以感知到 目标
		Proxy proxy = new Pursuit(schoolGirl);

		ProxyPerson proxyPerson = new ProxyPerson(proxy);
		proxyPerson.giveChocolate();
	}
}
