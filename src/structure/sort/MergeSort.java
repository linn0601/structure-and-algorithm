package structure.sort;

/**
 * 归并排序，分而治之
 */
public class MergeSort {

	public void mergeSort(int[] arr) {

		mergeSortA(arr, 0, arr.length - 1);
	}

	public void mergeSortA(int[] arr, int p, int r) {
		//递归条件终止
		if (p >= r) {
			return;
		}

		int q = (p + r) / 2;

		mergeSortA(arr, p, q);
		mergeSortA(arr, q + 1, r);

		//merge() 这里需要合并
	}
}
