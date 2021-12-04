package Sorting;

public class Heap {
	public static <T extends Comparable<T>> void heapSort(T arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
	private static <T extends Comparable<T>> void heapify(T arr[], int size, int i)
    {
        int largest = i;  // Initialize largest as root
        int left = 2*i + 1;  // left = 2*i + 1
        int right = 2*i + 2;  // right = 2*i + 2
 
        // If left child is larger than root
        if (left < size && (arr[left].compareTo(arr[largest])) > 0)
            largest = left;
 
        // If right child is larger than largest so far
        if (right < size && (arr[right].compareTo(arr[largest])) > 0)
            largest = right;
 
        // If largest is not root
        if (largest != i)
        {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, size, largest);
        }
    }
}
