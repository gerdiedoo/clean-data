import java.util.Arrays;

public class HeapSort {

	public void heapSort(int[] A) {

		int len = A.length;
		for (int i = 0; i < len - 1; i ++) {
			// lastIdx indicates the last element of the unsorted array
			int lastIdx = len - i - 1;

			// Step1: Build a max heap
			buildMaxHeap(A, lastIdx);

			// Step2: Swap the root and the last element
			swap(A, 0, lastIdx);
		}

	}

	private void buildMaxHeap(int[] A, int lastIdx) {

		// outer loop starts from the parent of the last element.
		// NOTE: for an element at index a, it has children at index (2*a+1) 
		// and (2*a+2), with its parent at index (a-1)/2
		for (int i = (lastIdx - 1) / 2; i >= 0; i --) {
			// use k to record the element may to be sift.
			int k = i;

			// if element at k has child/children
			while ((2 * k + 1) <= lastIdx) {
				// greaterIdx indicates the index of the greater child of k,
				// initiate it with the index of the left child
				int greaterIdx = 2 * k + 1;

				// if k has a right child and the right child is greater 
				// than the left one, then change the greaterIdx to the 
				// index of the right child, which is increased by 1
				if (greaterIdx < lastIdx) {
					if (A[greaterIdx] < A[greaterIdx + 1]) {
						greaterIdx ++;
					}
				}

				// sift down the parent node and update the value of k if needed,
				// or break the while loop
				if (A[k] < A[greaterIdx]) {
					swap(A, k, greaterIdx);
					k = greaterIdx;
				} else {
					break;
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
		HeapSort hs = new HeapSort();
		int[] A = {4, 5, 9, 2, 0, 1, 6, 8, 3, 7};
		System.out.println("unsorted: " + Arrays.toString(A));
		hs.heapSort(A);
 		System.out.println("sorted: " + Arrays.toString(A));
	}

}