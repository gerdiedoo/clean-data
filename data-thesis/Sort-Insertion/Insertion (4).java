package Sorting;

public class Insertion {
	
	//generic iterative implementation for insertion sort
	public static <T extends Comparable<T>> void InsertionSort(T arr[])
	{
		int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            T key = arr[i];
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j].compareTo(key) > 0)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
	}
	
		// generic Recursive implementation of InsertionSort
		// Mind the Stack
	    public static <T extends Comparable<T>> void InsertionSortRecursive(T arr[])
	    {
	    	//sort the array
	    	InsertionSortRecursiveHelper(arr, arr.length);
	    }
		
	    //Actual recursive insertion sort    
	    private static <T extends Comparable<T>> void InsertionSortRecursiveHelper(T arr[], int n)
	    {
	    	// Base case
	        if (n <= 1)
	            return;
	      
	        // Sort first n-1 elements
	        InsertionSortRecursiveHelper( arr, n-1 );
	      
	        // Insert last element at its correct position
	        // in sorted array.
	        T last = arr[n-1];
	        int j = n-2;
	      
	        /* Move elements of arr[0..i-1], that are
	          greater than key, to one position ahead
	          of their current position */
	        while (j >= 0 && arr[j].compareTo(last) > 0)
	        {
	            arr[j+1] = arr[j];
	            j--;
	        }
	        arr[j+1] = last;
	    }
}
