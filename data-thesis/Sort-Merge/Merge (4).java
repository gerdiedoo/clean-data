package Sorting;

import java.util.ArrayList;

public class Merge {
	
	public static <T extends Comparable<T>> void mergeSort(T arr[])
    {
		mergeSortHelper(arr,0,arr.length - 1);
    }
	
	//Generic Merge Sort Helper
	private static <T extends Comparable<T>> void mergeSortHelper(T arr[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int middle = (left + right)/2;
 
            // Sort first and second halves
            mergeSortHelper(arr, left, middle);
            mergeSortHelper(arr , middle + 1, right);
 
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
	
	//Helper Function to MergeSort - Merges back the array by type CompareTo function
	private static <T extends Comparable<T>> void merge(T arr[], int left, int middle, int right)
    {
        // Find sizes of arrays to be merged
        int first = middle - left + 1;
        int second = right - middle;
        
        //create arrayLists to hold values
        ArrayList<T> L = new ArrayList <T>();
        ArrayList<T> R = new ArrayList <T>();
 
        /*Copy data to temp arrayLists*/
        for (int i=0; i<first; ++i)
            L.add(i,arr[left + i]);
        for (int j=0; j<second; ++j)
        	R.add(j,arr[middle + j + 1]);
        
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Merge the Arrays
        int k = left;
        while (i < first && j < second)
        {
            if (L.get(i).compareTo(R.get(j)) <= 0)
            {
                arr[k] = L.get(i);
                i++;
            }
            else
            {
                arr[k] = R.get(j);
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < first)
        {
            arr[k] = L.get(i);
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < second)
        {
            arr[k] = R.get(j);
            j++;
            k++;
        }
    }
 }
