package structure.sort;

/**
 * 冒泡排序，通过flag=没有数据交换 可以减少比较提前推出
 */
public class BubbleSort {

	/*public void bubbleSort(int[] a) {
		if (a.length <= 1) {
			return;
		}

		for (int i = 0; i < a.length; ++i) {
			// 提前退出冒泡循环的标志位
			boolean flag = false;
			for (int j = 0; j < a.length - i - 1; ++j) {
				if (a[j] > a[j + 1]) { // 交换
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					flag = true;  // 表示有数据交换
				}
			}
			if (!flag) {
				break;  // 没有数据交换，提前退出
			}
		}
	}*/

	public static void main(String[] args) {

		int[] arr = { 3, 5, 6, 1, 2 };

		bubbleSort(arr);

		for (var ar : arr) {
			System.out.println(ar);
		}
	}

	/**
	 * 冒泡排序，从第一个开始，对比相邻的两个，然后交换位置，每次排序都会让一个一个元素到达本来的位置上
	 */
	public static void bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}

			}

			if (!flag) {
				break;
			}
		}
	}
}
