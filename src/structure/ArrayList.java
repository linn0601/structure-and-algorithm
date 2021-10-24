package structure;

import java.util.Arrays;

public class ArrayList<E> {

	private E[] data;

	private int size;

	private static final int DEFAULT_CAPACITY = 10;

	public ArrayList(int capacity) {
		this.data = (E[]) new Object[capacity];
	}

	public ArrayList(E[] arr) {
		this.data = (E[]) new Object[arr.length];

		for (int i = 0; i < arr.length; i++) {
			data[i] = arr[i];
			size = arr.length;
		}
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int capacity() {
		return data.length;
	}

	public int size() {
		return size;
	}

	public void addLast(E e) {
		insert(size, e);
	}

	public void addFirst(E e) {
		insert(0, e);
	}

	public void insert(int index, E e) {
		if (index < 0 || index > data.length) {
			throw new IllegalArgumentException("Index: " + index + ", Size: " + size);
		}

		int minCapacity = size + 1;

		resize(newCapacity(minCapacity));

		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		res.append(String.format("array size = %d, capacity = %d %n", size, data.length));
		res.append('[');
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(", ");
			}
		}
		return res.append(']').toString();
	}

	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		return data[index];
	}

	public void set(int index, E e) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		data[index] = e;
	}

	public int find(E e) {
		//先判断是否存在 contains
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	public E getLast() {
		return get(size - 1);
	}

	public E getFist() {
		return get(0);
	}

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	public E removeFist() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}

	//引用需要释放空间
	public E remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		E ret = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		data[size] = null;//这样就会被回收
		resize(newCapacity(size + 1));

		return ret;
	}

	// 只删除了一个元素
	public void removeElement(E e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	private void resize(int newCapacity) {
		if (newCapacity != capacity()) {
			data = Arrays.copyOf(data, newCapacity);
		}
	}

	public int newCapacity(int minCapacity) {
		int oldCapacity = capacity();

		if (minCapacity < oldCapacity >> 1) {
			return (oldCapacity >> 1);
		}
		else if (oldCapacity > size && oldCapacity >= minCapacity) {
			return oldCapacity;
		}
		else if (oldCapacity < minCapacity) {
			int newCapacity = data.length + (capacity() >> 1);
			return Math.max(newCapacity, DEFAULT_CAPACITY);
		}

		throw new IllegalArgumentException("参数非法");
	}

	public void swap(int i, int j) {
		if (i >= size || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
		}

		if (j >= size || j < 0) {
			throw new IndexOutOfBoundsException("Index: " + j + ", Size: " + size);
		}

		E temp = get(i);
		data[i] = get(j);
		data[j] = temp;
	}

}
