package structure.sort;

public class ShellSort {

	public static void shellSort(int[] arr) {
		int temp;

		for (int step = arr.length / 2; step >= 1; step /= 2) {
			for (int i = step; i < arr.length; i++) {
				temp = arr[i];

				int j = i - step;

				while (j >= 0 && arr[j] > temp) {
					arr[j + step] = arr[j];
				}
				arr[j + step] = temp;
			}
		}
	}
}
