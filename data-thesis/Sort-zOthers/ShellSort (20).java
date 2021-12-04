import java.util.Arrays;

/**
* An implementation of the video: https://www.youtube.com/watch?v=SCBf7aqKQEY
*/

public class ShellSort {

	public void shellSort(int[] A) {

		int len = A.length;
		for (int increment = len / 2; increment > 0; increment /= 2) {
			for (int i = 0; i + increment < len; i ++ ) {
				for (int j = i + increment; j >= increment; j -= increment) {
					if (A[j] < A[j - increment]) {
						swap(A, j, j - increment);
					}
				}
			}
		}

	}

	private void swap(int[] A, int idx1, int idx2) {

		int tmp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = tmp;

	}

	public static void main(String[] args) {
		ShellSort ss = new ShellSort();
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		System.out.println("unsorted: " + Arrays.toString(A));
		ss.shellSort(A);
		System.out.println("sorted: " + Arrays.toString(A));
	}

}
