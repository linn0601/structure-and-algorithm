package schema.decorator.schema;

public class Finery extends Person{

	protected Person component;

	// 打扮
	public void decorate(Person component){
		this.component = component;
	}

	public void show(){
		if (component != null){
			component.show();
		}
	}
}
