package structure.sort;

import java.util.Arrays;

/**
 * 归并排序，分而治之 在归并的过程中需要辅助空间，因此并不是原地排序，时间复杂度为nlog(n)
 */
public class MergeSort {

	public void mergeSort(int[] arr) {

		int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
		mergeSortA(arr, 0, arr.length - 1, temp);
	}

	public void mergeSortA(int[] arr, int l, int r, int[] temp) {
		// 递归条件终止
		if (l >= r) {
			return;
		}

		int mid = l + (r - l) / 2;

		mergeSortA(arr, l, mid, temp);
		mergeSortA(arr, mid + 1, r, temp);

		// 一个小优化，在最理想的情况下时间复杂度趋近于 O(n)
		if (arr[mid] > (arr[mid + 1])) {
			// 合并逻辑
			merge(arr, l, mid, r, temp);
		}
	}

	private void merge(int[] arr, int l, int mid, int r, int[] temp) {

		System.arraycopy(arr, l, temp, l, r - l + 1);

		int i = l;
		int j = mid + 1;

		for (int k = l; k <= r; k++) {
			// arr[i] arr[j]
			if (i > mid) {
				arr[k] = temp[j];
				j++;
			}
			else if (j > r) {
				arr[k] = temp[i];
				i++;
			}
			else if (temp[i] >= (temp[j])) {
				arr[k] = temp[i];
				i++;
			}
			else {
				arr[k] = temp[j];
				j++;
			}
		}
	}
}
