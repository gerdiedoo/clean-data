// Selection sort algorithm
public class SelectionSort
{
    private int[] A;

    // Constructor
    public SelectionSort(int[] data)
    {
        A = data;
    }

    public int[] sort()
    {
        int a_len = A.length;

        // Iterate over the array
        for(int i=0; i<a_len-1; i++)
        {
            // Set the current minimum
            int curr_min = i;
            
            // Scan the rest of the array
            for(int j=i+1; j<a_len; j++)
            {
                // If the element A[j] is less than the current minimum 
                // then set the new minimum.
                if(A[j] < A[curr_min])
                {
                    curr_min = j;
                }
            }

            // Swap A[i] with the current minimum.
            swap(A, i, curr_min);
        }

        // Return the sorted array
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