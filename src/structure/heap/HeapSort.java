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

	// 原地堆排序 nlogn 堆 的最佳实现不是排序而是优先队列
	public static <E extends Comparable<E>> void headSort(E[] data) {

		if (data.length <= 1) {
			return;
		}

		for (int i = (data.length - 2) / 2; i >= 0; i--) {
			siftDown(data, i, data.length);
		}

		for (int i = data.length - 1; i >= 0; i--) {
			swap(data, 0, i);

			siftDown(data, 0, i);
		}
	}

	// 从[0-n) 所形成的最大堆, 索引为k 执行siftDown
	private static <E extends Comparable<E>> void siftDown(E[] data, int k, int n) {
		// 根元素和2个子节点比较，与较大的进行交换
		while (2 * k + 1 < n) {
			// 可能没有右孩子
			int j = 2 * k + 1; // 比较左右孩子谁大
			// 首先找到左右最大值的索引，如果没有就用左孩子
			if (j + 1 < n && data[j + 1].compareTo(data[j]) > 0) {
				j++;
			}

			// 比较孩子是否大于父节点，如果小于，表示没有违反堆的性质
			if (data[k].compareTo(data[j]) >= 0) {
				break;
			}
			// 进行交换
			swap(data, j, k);
			k = j;
		}
	}

	private static <E extends Comparable<E>> void swap(E[] data, int i, int j) {
		E temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
