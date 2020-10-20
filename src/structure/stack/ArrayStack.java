package structure.stack;

import java.util.Objects;

/**
 * 数组实现的栈 --- 顺序栈
 */
public class ArrayStack<E> implements Stack<E> {

	private final E[] array; //数组
	private int size; //容量

	public ArrayStack(int capacity) {
		this.array = (E[]) new Objects[capacity];
		this.size = 0;
	}

	//入栈操作
	@Override
	public boolean push(E e) {

		if (array.length == size) {
			return false;
		}

		array[size] = e;
		++size;
		return true;
	}

	//出栈操作
	@Override
	public E pop(){
		if (array.length == 0){
			return null;
		}

		E e = array[size-1];
		--size;
		return e;
	}

}
