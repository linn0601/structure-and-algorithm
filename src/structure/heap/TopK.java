package structure.heap;

import java.util.Collections;
import structure.queue.PriorityQueue;

public class TopK {

	// 求 Top k 前n个值
	public int[] getLeastNumbers(int[] arr, int k) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			priorityQueue.enqueue(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (!priorityQueue.isEmpty() && arr[i] < priorityQueue.getFront()) {
				priorityQueue.dequeue();
				priorityQueue.enqueue(arr[i]);
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = priorityQueue.dequeue();
		}

		return result;
	}

	// 基于Java标准库
	public static void main(String[] args) {
		java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(Collections.reverseOrder());

		pq.add(5);
		pq.add(8);

		System.out.println(pq.peek());
	}

	// 求解决数组中第k个最大元素
	// java.util.PriorityQueue 默认实现是一个最小堆
	public static int findKthLargest(int[] arr, int k) {

		// 用于存储arr 前8个元素
		java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (!pq.isEmpty() && arr[i] > pq.peek()) {
				pq.remove();
				pq.add(arr[i]);
			}
		}

		return pq.peek();
	}

	// 求解数组中 最小的k个树 使用最大堆
	public static int[] getLeastNumbers1(int[] arr, int k) {

		// 最大堆
		java.util.PriorityQueue<Integer> minPriorityQueue = new java.util.PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			minPriorityQueue.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (!minPriorityQueue.isEmpty() && arr[i] < minPriorityQueue.peek()) {
				minPriorityQueue.remove();
				minPriorityQueue.add(arr[i]);
			}
		}

		int[] result = new int[k];

		for (int i = 0; i < k; i++) {
			result[i] = minPriorityQueue.remove();
		}

		return result;
	}
}
