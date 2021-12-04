// Insertion sort algorithm
public class InsertionSort
{
    private int[] A;
    
    // Constructor
    public InsertionSort(int[] data)
    {
        A = data;
    }
    
    public int[] sort()
    {
        int i, j, v;
        int a_len = A.length;
        
        for(i=0; i<a_len; i++)
        {
            v = A[i];
            j = i - 1;
            
            // While index is positive and element is greater than A[i] 
            // scan and insert A[i] into its proper position.
            while((j >= 0) && (A[j] > v))
            {
                A[j+1] = A[j];
                j = j - 1;
            }
            
            A[j+1] = v;
        }
        
        // Return the sorted array
        return A;
    }
}