package structure.search;

import java.util.Arrays;

/**
 * 二分搜索
 * code 1101号问题和 875号问题
 */
public class BinarySearch {

	public static void main(String[] args) {

		//[30,11,23,4,20], H = 6
		int[] arr3 = new int[] { 30, 11, 23, 4, 20 };
		System.out.println(minEatingSpeed(arr3,6));

		int[] arr = new int[] { 3, 5, 6, 7, 8, 10, 13, 15, 16 };
		int[] arr1 = new int[] { 1, 2, 3, 1, 1 };

		System.out.println(shipWithinDays(arr1, 6));
	}

	public static int binarySearch1(int[] arr, int c) {

		int l = 0;
		int r = arr.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == c) {
				return mid;
			}
			if (arr[mid] < c) {
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int c) {
		return binarySearch2(arr, c, 0, arr.length - 1);
	}

	// solution
	public static int binarySearch2(int[] arr, int c, int l, int r) {

		int mid = l + (r - l) / 2;

		if (arr[mid] == c) {
			return mid;
		}

		if (arr[mid] > c) {
			return binarySearch2(arr, c, l, mid - 1);
		}
		else {
			return binarySearch2(arr, c, mid + 1, r);
		}
	}

	/**
	 * arr[l,r)查找
	 */
	public static int binarySearch3(int[] arr, int target) {
		int l = 0;
		int r = arr.length;

		while (l < r) {
			int mid = l + (r - l) / 2;

			if (arr[mid] == target) {
				return mid;
			}
			if (arr[mid] < target) {
				l = mid + 1;
			}
			else {
				r = mid;
			}
		}
		return -1;
	}

	/**
	 * 二分查找法，查找比目标值第一大的值
	 */
	public static int binarySearchFirstMax(int[] arr, int target) {

		// 从 l 到 r /2
		int l = 0;
		int r = arr.length;

		while (l != r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] >= target) {
				r = mid;
			}

			else {
				l = mid + 1;
			}
		}

		return l;
	}

	/**
	 * 问题 1101
	 */
	public static int shipWithinDays(int[] weights, int target) {
		int l = Arrays.stream(weights).max().getAsInt();
		int r = Arrays.stream(weights).sum();

		while (l < r) {

			// 如果传送带运载力mid，运完货物需要的天数<= D
			int mid = l + (r - l) / 2;

			// target 目标天数
			if (days(weights, mid) <= target) {
				r = mid;
			}
			else {
				l = mid + 1;
			}
		}
		return l;
	}

	private static int days(int[] weights, int k) {

		// 当前载重
		int cur = 0;
		// 返回结果
		int result = 1;

		for (var weight : weights) {
			//如果当前的重量没有超过k 表示可再运
			if (cur + weight <= k) {
				cur += weight;
			}
			else {
				result++;
				cur = weight;
			}
		}
		return result;
	}

	/**
	 * 875 珂珂吃香蕉,计算珂珂吃香蕉的最小速度 二分查找适用于单调性的问题。每小时吃的越少，总用时越长
	 *
	 * @param h 用时
	 */
	public static int minEatingSpeed(int[] piles, int h) {
		// 最慢吃多少根
		int l = 1;
		int r = Arrays.stream(piles).max().getAsInt();

		while (l < r) {
			int mid = l + (r - l) / 2;

			if (eatingTime(piles, mid) <= h) {
				r = mid;  // 寻找更小得解
			}
			else {
				l = mid + 1;
			}
		}
		return l;
	}

	private static int eatingTime(int[] piles, int q) {
		int h = 0;
		for (var d : piles) {
			h += d % q + (d % q == 0 ? 0 : 1);
		}
		return h;
	}
}
