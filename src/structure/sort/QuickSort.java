package structure.sort;

import java.util.Random;

/**
 * 非常优秀的排序算法 归并排序是不管数组的内容是什么就开始干 归并 与 快排 n log n 快速排序是先进行 partition 在进行2次递归，而归并排序是先进行递归后在进行merge
 *
 * 双端快排序 i > j  l 与j 交换
 */
public class QuickSort {
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
	 * 分区排序
	 *
	 * i 为前进索引 arr[l+1, j] < v && arr[j+1, i-1] > v 然后将l 位置 和 j 位置交换 这样 v 左边都是小于v的 右边都是大于v的
	 */
	private static int partition(int[] arr, int l, int r) {
		// 生成l 到 r 之间随机的索引
		int p = l + random.nextInt(r - l + 1); // 开区间
		swap(arr, l, p);

		// arr[l+1, j] < v
		// arr[j+1, i-1] > v
		// j 和 j+1 互换
		// i 与 l 位置比较, > i++ 小于则j+1,i 位置与j互换并且i++
		int j = l;

		for (int i = l + 1; i <= r; i++) {
			if (arr[i] < arr[l]) {
				// 需要与j+1 换位置
				j++;
				swap(arr, i, j);
			}
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
