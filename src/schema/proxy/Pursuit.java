package schema.proxy;

/**
 * 追求着类
 */
public class Pursuit implements Proxy {

	private  final SchoolGirl schoolGirl;

	public Pursuit(SchoolGirl schoolGirl) {
		this.schoolGirl = schoolGirl;
	}

	@Override
	public void giveDolls() {
		System.out.println(schoolGirl.getName() + " 送洋娃娃");
	}

	@Override
	public void giveFlowers() {
		System.out.println(schoolGirl.getName() + " 送鲜花");
	}

	@Override
	public void giveChocolate() {
		System.out.println(schoolGirl.getName() + " 送你巧克力");
	}
}
