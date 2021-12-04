import java.util.Arrays;
import java.util.Random;


public class QuickSort{

	public void quickSort(int[] A) {
		int low = 0;
		int high = A.length - 1;
		quickSort(A, low, high);
	}

	private void quickSort(int[] A, int low, int high) {
		if (low < high) {
			int pivotIdx = getPivot(low, high);
			swap(A, low, pivotIdx); // move the pivot to the left of the array.
			int partitionIdx = partition(A, low, high);
			quickSort(A, low, partitionIdx - 1); // sort the left part
			quickSort(A, partitionIdx + 1, high); // sort the right part
		}
	}

	/**
	 * return a randomly selected index for the pivot
	 * @param  low  starting index
	 * @param  high ending index
	 * @return      a random value in [low, high] as the index of the pivot
	 */
	private int getPivot(int low, int high) {
		Random random = new Random();
		return random.nextInt(high - low + 1) + low; //plus 1 in order to include "high"
	}

	private void swap(int[] A, int idx1, int idx2) {
		int tmp = A[idx1];
		A[idx1] = A[idx2];
		A[idx2] = tmp;
	}

	/**
	 * move the smaller element to the left and the greater one to the right, 
	 * then place the pivot correctly and return its index as a partition point
	 * @param  A    the array to be sorted
	 * @param  low  starting index
	 * @param  high ending index
	 * @return      the partition point
	 */
	private int partition(int[] A, int low, int high) {
		int i = low, j = high;
		while (i != j) {

			//right guard goes from high to low
			//to find the element smaller than the pivot
			//RIGHT guard has to go FIRST.
			while (A[j] >= A[low] && i < j) {
				j --;
			}

			//left guard goes from low to high
			//to find the element greater than the pivot
			while (A[i] <= A[low] && i < j) {
				i ++;
			}

			//if found, swap them and continue
			if (i < j) {
				swap(A, i, j);
			}
		}
		swap(A, low, i);
		return i;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		System.out.println(Arrays.toString(A));
		qs.quickSort(A);
		System.out.println(Arrays.toString(A));

	}

}