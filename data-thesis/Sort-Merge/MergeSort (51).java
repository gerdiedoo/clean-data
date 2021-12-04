package ie.gmit.dip;
import java.util.Random;


public class MergeSort {
    
 // Driver method 
    public static void main(String[] args) {
        
        // TODO code application logic here
        Random g = new Random();
        
       int [] number = new int [10000]; //alternated and run 10 times manually

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(number.length)+1;
            number[d] = RandomG;
            System.out.print(" " +RandomG);
        }

        System.out.println("Given Array"); 
        printArray(number); 
    
        long startTime= System.nanoTime();
  
        MergeSort ob = new MergeSort(); 
        ob.sort(number, 0, number.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(number); 
        
        long endTime= System.nanoTime();
        long elapsed = endTime-startTime;
        double timeMillis= elapsed/1000000.0;
        System.out.print("\nSorted In: "+ timeMillis );
        System.out.print("\n" );

    }


  // Merges two subarrays of number[]. 
    
    void merge(int number[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = number[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = number[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                number[k] = L[i]; 
                i++; 
            } 
            else
            { 
                number[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            number[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            number[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int number[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(number, l, m); 
            sort(number , m+1, r); 
  
            // Merge the sorted halves 
            merge(number, l, m, r); 
        } 
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int number[]) 
    { 
        int n = number.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(number[i] + " "); 
        System.out.println(); 
    } 
  
  
} 
