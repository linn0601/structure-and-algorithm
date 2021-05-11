package structure.sort;

import java.util.Random;

/**
 * 非常优秀的排序算法 归并排序是不管数组的内容是什么就开始干 归并 与 快排 n log n 快速排序是先进行 partition 在进行2次递归，而归并排序是先进行递归后在进行merge
 *
 * 双端快排序 i > j  l 与j 交换
 */
public class QuickSort2 {
	private static final Random random = new Random();

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 3, 5, 4 };

		quickSort(arr);

		for (var a : arr) {
			System.out.print(a + " ");
		}
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {

		if (l >= r) {
			return;
		}
		// 标定点
		int p = partition(arr, l, r);

		quickSort(arr, l, p - 1);
		quickSort(arr, p + 1, r);
	}

	/**
	 * 双路快排
	 */
	private static int partition(int[] arr, int l, int r) {

		int pivot = l + random.nextInt(r - l + 1);
		// 选择标定值pivot
		swap(arr, l, pivot);

		int i = l + 1;
		int j = r;

		while (true) {
			while (i <= j && arr[l] > arr[i]) {
				i++;
			}
			while (i <= j && arr[l] < arr[j]) {
				j--;
			}
			if (i >= j) {
				break;
			}

			swap(arr, i, j);
 			j--;

		}
		swap(arr, l, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
