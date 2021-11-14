package schema.proxy;

/**
 * 代理对象
 */
public class ProxyPerson {

	private final Proxy proxy;

	public ProxyPerson(Proxy proxy) {
		this.proxy = proxy;
	}

	public void giveDolls() {
		proxy.giveDolls();
	}

	public void giveFlowers() {
		proxy.giveFlowers();
	}

	public void giveChocolate() {
		proxy.giveChocolate();
	}
}
