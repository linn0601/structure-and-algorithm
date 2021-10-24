package structure.queue;

import structure.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	// 底层数据结构是一个最大堆
	private MaxHeap<E> maxHeap;

	public PriorityQueue() {
		this.maxHeap = new MaxHeap<>();
	}

	@Override
	public int getSize() {
		return maxHeap.size();
	}

	@Override
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		maxHeap.add(e);
	}

	@Override
	public E dequeue() {
		// extractMax 取出最大的元素后进行，重新整合成一个最大堆
		return maxHeap.extractMax();
	}

	@Override
	public E getFront() {
		return maxHeap.findMax();
	}

	public void replace(E e) {
		maxHeap.replace(e);
	}
}
