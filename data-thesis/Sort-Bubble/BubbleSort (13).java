// Bubblesort algorithm
public class BubbleSort
{
    private int[] A;
    
    // Constructor
    public BubbleSort(int[] data)
    {
        A = data;
    }
    
    public int[] sort()
    {
        int i, j;
        
        // Compare adjacent elements of the array and exchange the 
        // values if they are out of order.
        for(i=0; i<A.length-1; i++)
        {
            for(j=0; j<A.length-1-i; j++)
            {
                if(A[j+1] < A[j])
                {
                    swap(A, j, j+1);
                }
            }
        }
        
        return A;
    }
    
    // Swap array elements at A[u] and A[v].
    private void swap(int[] A, int u, int v)
    {
        int temp;
        
        temp = A[u];
        A[u] = A[v];
        A[v] = temp;
    }
}