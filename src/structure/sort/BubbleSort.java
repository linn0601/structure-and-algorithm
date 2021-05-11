package structure.sort;

/**
 * 冒泡排序，通过flag=没有数据交换 可以减少比较提前推出
 */
public class BubbleSort {

	public void bubbleSort(int[] a) {
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
	}
}
