# Implementation of Selection sort algorithm for sorting
class SelectionSort:

    # Sort input array
    def sort(A):

        # Swap array elements at indices u and v
        def swap(A, u, v):
            temp = A[u]
            A[u] = A[v]
            A[v] = temp

        # Get length of array
        a_len = len(A)

        # Iterate over the array
        for i in range(0, a_len - 1):
            # Set the current minimum
            curr_min = i

            # Scan the rest of array
            for j in range(i+1, a_len):
                
                # If the element A[j] is less that the
                # current minimum then set the new minimum.
                if(A[j] < A[curr_min]):
                   curr_min = j

            # Swap A[i] with the current minimum.
            swap(A, i, curr_min)

        # Return the sorted array
        return A

        
