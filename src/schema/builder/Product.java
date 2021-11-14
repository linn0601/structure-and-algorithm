package schema.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类：由多个部件组成
 */
public class Product {

	List<String> parts = new ArrayList<>();

	public void add(String part) {
		parts.add(part);
	}

	public void show() {
		System.out.println("创建产品 ： ");

		for (var part : parts) {
			System.out.println(part);
		}
	}
}
