package structure.heap;

public class HeapSort {

	private HeapSort() {

	}

	// 堆的排序
	// 1.堆可以原地排序
	// 2。O(n log n) 和归并排序 一样
	public static <E extends Comparable<E>> void sort(E[] data) {

		MaxHeap<E> maxHeap = new MaxHeap<>();

		for (var e : data) {
			maxHeap.add(e);
		}

		for (int i = data.length - 1; i >= 0; i--) {
			data[i] = maxHeap.extractMax();
		}
	}
}
