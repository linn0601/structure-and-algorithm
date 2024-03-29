package structure.sort;

/**
 * 插入排序是一种稳定的排序方式, O(n^2)的时间复杂度在数据规模较小时性能优于归并
 */
public class InsertionSort {

	public static void insertSort(int[] a) {
		if (a.length <= 1) {
			return;
		}

		for (int i = 1; i < a.length; ++i) {
			int temp = a[i];  //保存后面的一个临时空间
			int j = i - 1;

			for (; j > 0; --j) {
				if (a[j] > a[j + 1]) {
					a[j + 1] = a[j]; //如果前面一个比后面一个大，那么把前面的赋值给后面的的
				}
				else {
					break;
				}
			}
			a[j + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 6, 5, 2, 4, 3 };

		insertSort(a);
	}

	// 分为有序 初时为第一个元素 和未排序区, 将未排序数据插入到有序区
	public static void insertSort1(int[] arr) {

		for (int i = 1; i < arr.length; i++) { // 无序区从索引1开始
			// 有序区 i - 1
			int j = i - 1;
			int temp = arr[i];

			for (; j > 0; j--) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j + 1];
				}
				else {
					break;
				}
			}
			// 无序区的第一个元素，带排序元素
			arr[j + 1] = temp;

		}
	}

	// 选择排序
	public static void selectorSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;

			// 获取真的最小值
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// 交换
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}
