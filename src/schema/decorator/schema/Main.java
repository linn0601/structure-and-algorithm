package schema.decorator.schema;

import schema.decorator.schema.decorator.BigTrouser;
import schema.decorator.schema.decorator.Tshirts;

public class Main {

	/**
	 * 装饰模式是为了已有的功能添加更多功能的一种方式，而这些新加入的功能只会在某些特定的条件下才会触发，而装饰模式却提供了一个非常好的解决方案，他把每个要装饰的放在单独的类中，并让这个类包装称他所需要的装饰对象。
	 * 当需要执行特殊行为时，客户代码就可以在运行时根据需要有选择地按顺序特使用装饰功能包装对象了。
	 * @param args
	 */
	public static void main(String[] args) {
		Person person = new Person("小菜");

		System.out.println("第一种装扮 ：");

		BigTrouser bigTrouser = new BigTrouser();
		Tshirts tshirts = new Tshirts();

		bigTrouser.decorate(person);
		tshirts.decorate(bigTrouser);

		tshirts.show();
	}
}
