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
}
