package schema.siigleton;

public class LazySingletonTest {

	public static void main(String[] args) {
		new Thread(() -> {
			LazySingleton instance = LazySingleton.getInstance();
			System.out.println(instance);
		}).start();

		new Thread(() -> {
			LazySingleton instance = LazySingleton.getInstance();
			System.out.println(instance);
		}).start();
	}

}

class LazySingleton {

	private static volatile LazySingleton instance; // volatile 禁止重排序

	private LazySingleton() {
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					// 字节码层面
					// 1.在堆中创建一块地址，并返回地址的引用
					// 2.invokespecial 对堆中地址进行初始化
					// 3.赋值
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}
