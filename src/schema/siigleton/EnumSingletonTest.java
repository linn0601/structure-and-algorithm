package schema.siigleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {

	public static void main(String[] args)
		throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);
		EnumSingleton instance = constructor.newInstance("INSTANCE", 0);
	}
}

enum EnumSingleton {

	INSTANCE;

	public void print() {
		System.out.println(this.hashCode());
	}
}
