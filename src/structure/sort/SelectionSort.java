package structure.sort;

import java.util.Collections;

/**
 * 排序算法： 选择排序算法【原地排序 不稳定】
 *
 * 最好时间复杂度 是 O(n) 最坏时间复杂度 是 O(n^2)
 *
 * 在一堆元素中把最小的拿出来，然后再把剩下的元素中最小的拿出来，不断地获取最小的元素
 */
class SelectionSort {

	private SelectionSort() {
	}

	// 如果方法处理泛型，要对泛型进行约束，<E extend ?>
	public static <E extends Comparable<E>> void selectionSort(E[] arr) {
		for (int i = 0; i < arr.length; i++) {

			int minIndex = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex].compareTo(arr[j]) > 0) {
					minIndex = j;
				}
			}
			// 第一层循环运行n轮， 第二层循环 运行 n-1 次  n-2 次  1 + 2 + ... + n 等差数列 （1 + n) * n /2
			swap(arr, i, minIndex);
		}
	}

	public static void selectionSort1(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			int maxIndex = i;

			for (int j = maxIndex - 1; j >= 0; j--) {
				if (arr[maxIndex] < arr[j]) {
					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				int temp = arr[i];
				arr[i] = arr[maxIndex];
				arr[maxIndex] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 6, 3, 4, 5, 2, 1 };

		selectionSort1(arr);

		Collections.singletonList(arr).forEach(System.out::println);
	}

	private static <E> void swap(E[] arr, int j, int minIndex) {
		if (minIndex != j) {
			E temp = arr[j];
			arr[j] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}

}
