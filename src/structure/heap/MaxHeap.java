package structure.heap;

import structure.ArrayList;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

	private ArrayList<E> data;

	public MaxHeap(int capacity) {
		data = new ArrayList<>(capacity);
	}

	public MaxHeap() {
		data = new ArrayList<>();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	// 返回当前索引的父节点的索引
	private int parent(int index) {

		if (index == 0) {
			throw new IllegalArgumentException("index-0 doesnt have parent.");
		}
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return index * 2 + 1;
	}

	private int rightChild(int index) {
		return index * 2 + 2;
	}

	// 向堆中添加元素
	public void add(E e) {
		data.addLast(e);

		// 维护堆的性质
		// sift up
		siftUp(data.size() - 1);
	}

	public E extractMax() {
		E ret = findMax();

		data.swap(0, data.size() - 1);
		data.removeLast();

		siftDown(0); // 对索引为0 进行下沉

		return ret;
	}

	public E findMax() {
		if (data.isEmpty()) {
			throw new IllegalArgumentException(" heap is empty");
		}
		else {
			return data.get(0);
		}
	}

	private void siftDown(int k) {
		// 取出根元素和最后一个元素交互
		// 根元素和2个子节点比较，与较大的进行交换
		while (leftChild(k) < data.size()) {
			// 可能没有右孩子
			int j = leftChild(k); // 比较左右孩子谁大
			// 首先找到左右最大值的索引，如果没有就用左孩子
			if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
				j = rightChild(k);
			}

			// 比较孩子是否大于父节点，如果小于，表示没有违反堆的性质
			if (data.get(k).compareTo(data.get(j)) >= 0) {
				break;
			}
			// 进行交换
			data.swap(j, k);
			k = j;
		}
	}

	private void siftUp(int k) {

		while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			// 上浮
			data.swap(parent(k), k);
			k = parent(k);
		}
	}

	// replace 取出最大元素后，放入一个新的元素


}
