package Sorting;

public class Quick { 
  
	public static <T extends Comparable<T>> void quickSort(T arr[])
    {
		quickSortHelper(arr,0,arr.length - 1);
    }
	
	private static <T extends Comparable<T>> void quickSortHelper(T arr[], int low, int high)
    {
        if (low < high)
        {
            //partition index
            int index = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSortHelper(arr, low, index-1);
            quickSortHelper(arr, index+1, high);
        } 
    }
  
	private static <T extends Comparable<T>> int partition(T arr[], int low, int high)
    {
        T pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j = low; j <high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j].compareTo(pivot) <= 0)
            {
                i++;
 
                //Swap elements
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i+1;
    }   
}
