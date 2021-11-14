package schema.decorator;

/**
 * 装饰模式：动态的给一个对象添加一些额外的只能，装饰模式提供了比继承更灵活的方案，符合开闭原则
 */
public abstract class Decorator implements Component{

	protected Component component;

	public void setComponent(Component component){
		this.component = component;
	}

	@Override
	public void operation() {
		if (component != null){
			component.operation();
		}
	}
}
