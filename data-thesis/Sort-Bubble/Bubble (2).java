package Sorting;

public class Bubble {
	
	//generic Iterative implementation of BubbleSort
	public static <T extends Comparable<T>> void BubbleSort(T arr[])
    {
		int n = arr.length;
        int i, j; 
        T temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) 
            {
                if (arr[j].compareTo(arr[j+1]) > 0) 
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // IF no two elements were 
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
	
	// generic Recursive implementation of BubbleSort
	// Mind the stack
    public static <T extends Comparable<T>> void BubbleSortRecursive(T arr[])
    {
    	//sort the array
    	BubbleSortRecursiveHelper(arr, arr.length);
    }
	
    //Actual recursive bubble sort
    private static <T extends Comparable<T>> void BubbleSortRecursiveHelper(T arr[], int n)
    {
        // Base case
        if (n == 1)
            return;
      
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++)
            if (arr[i].compareTo(arr[i+1]) > 0)
            {
                // swap arr[i], arr[i+1]
                T temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
      
        
        // recur for remaining array
        BubbleSortRecursiveHelper(arr ,n-1);
    }
	//and all primitive Types
}
