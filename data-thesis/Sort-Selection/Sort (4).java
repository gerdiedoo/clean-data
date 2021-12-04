import java.io.FileNotFoundException;
import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Date;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;


public class Assignment1 {



    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

    //------------------------------------------BINARYSEARCH STARTED----------------------------------------------------


    public static int binarySearch(int arr[], int first, int last, int key){
        if (last>=first){
            int mid = first + (last - first)/2;
            if (arr[mid] == key){
                return mid;
            }
            if (arr[mid] > key){
                return binarySearch(arr, first, mid-1, key);//search in left subarray
            }else{
                return binarySearch(arr, mid+1, last, key);//search in right subarray
            }
        }
        return -1;
    }




    //------------------------------------------BINARYSEARCH STARTED----------------------------------------------------



    //------------------------------------------SELECTION SORT STARTED--------------------------------------------------


    void selectionsorts(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //------------------------------------------SELECTION SORT ENDED----------------------------------------------------







    //------------------------------------------INSERTION SORT STARTED--------------------------------------------------
    void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {

            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */

            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    //------------------------------------------INSERTION SORT ENDED----------------------------------------------------








    //------------------------------------------RADIX SORT STARTED------------------------------------------------------

    //MAX VALUE IN ARRAY
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void Radix(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // A utility function to print an array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }

    //------------------------------------------RADIX SORT ENDED--------------------------------------------------------








    //------------------------------------------MERGE SORT STARTED------------------------------------------------------

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void merger(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            merger(arr, l, m);
            merger(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /* A utility function to print array of size n */
    static void printer(int arr[])
    {
        int n = arr.length;

        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    //------------------------------------------MERGE SORT ENDED--------------------------------------------------------



    //------------------------------------------GENERATE ARRAY MAIN-----------------------------------------------------

    static void getyourarray(int n[]){
        for (int i = 0; i < n.length; i++) {


            n[i] =getRandomNumberInRange(0,20000);
            if(n[i] <0)
                System.out.println("ERROR");

        }


    }
    //------------------------------------------MERGE SORT ENDED--------------------------------------------------------

    //------------------------------------------INSERTION SORT MAIN-----------------------------------------------------


    static void insertionfunction(){
        Assignment1 ob = new Assignment1();

        int[] insertions = new int[10];
        getyourarray(insertions);

        System.out.println("Insertion sort");
        ob.sort(insertions);
        printer(insertions);

    }
    //------------------------------------------INSERTION SORT MAIN-----------------------------------------------------

    //------------------------------------------RADIX SORT MAIN---------------------------------------------------------

    static void radixfunction(){
        Assignment1 ob = new Assignment1();
        int[] radixs = new int[100];
        getyourarray(radixs);
        int n = radixs.length;
        System.out.println("Radix sort");

        Radix(radixs, n);
        print(radixs, n);
        System.out.println();


    }
    //------------------------------------------RADIX SORT MAIN---------------------------------------------------------

    //------------------------------------------MERGE SORT MAIN---------------------------------------------------------

    static void mergefunction(){
        Assignment1 ob = new Assignment1();
        int[] merges = new int[1000];
        getyourarray(merges);

        System.out.println("Merge sort");
        ob.merger(merges, 0, merges.length-1);
        printer(merges);

    }
    //------------------------------------------MERGE SORT MAIN---------------------------------------------------------





    //------------------------------------------SELECTION SORT MAIN-----------------------------------------------------


    static void selectionfunction(){
        Assignment1 ob = new Assignment1();
        int[] selections = new int[1000];
        getyourarray(selections);

        System.out.println("Insertion sort");
        ob.selectionsorts(selections);
        printer(selections);

    }
    //------------------------------------------SELECTION SORT MAIN-----------------------------------------------------




    //------------------------------------------BINARY SEARCH MAIN------------------------------------------------------

    static void binaryfunction(){
        Assignment1 ob = new Assignment1();
        int[] binarysearches = new int[100000];
        getyourarray(binarysearches);
        int n = binarysearches.length;
        int last = binarysearches.length - 1;
        Random ra = new Random();
        int key;
        key = ra.nextInt();
        if(key >= 0) {
            int result = binarySearch(binarysearches, 0, last, key);
            if (result == -1)
                System.out.println("Element is not found!");
            else
                System.out.println("Element is found at index: " + result);
        }
        else if(key <0){
            key = -(key);
            int result = binarySearch(binarysearches, 0, last, key);
            if (result == -1)
                System.out.println("Element is not found!");
            else
                System.out.println("Element is found at index: " + result);


        }
        else
            System.out.println("False Error");



    }
    //------------------------------------------BINARY SEARCH MAIN------------------------------------------------------





    public static void main(String[] args) {


        //Phase 1 :
        //--------------------------------------------------------------------------------------------------------------
        //INSERTION SORT FOR MAIN
        insertionfunction();


        //Phase 2 :
        //--------------------------------------------------------------------------------------------------------------
        //RADIX SORT FOR MAIN

        radixfunction();


        //Phase 3 :
        //--------------------------------------------------------------------------------------------------------------
        //MERGE SORT FOR MAIN

        mergefunction();


        //Phase 4 :
        //--------------------------------------------------------------------------------------------------------------
        //SELECTION SORT FOR MAIN
        selectionfunction();

        //Phase 5 :
        //--------------------------------------------------------------------------------------------------------------
        //BINARYSEARCH SORT FOR MAIN
        binaryfunction();







    }
}
