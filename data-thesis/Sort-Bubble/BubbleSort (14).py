# Implementation of Bubblesort algorithm for sorting
class BubbleSort:
    
    # Sort input array
    def sort(A):
        
        # Swap array (A) elements at indices u and v
        def swap(A, u, v):
            temp = A[u]
            A[u] = A[v]
            A[v] = temp
            return
        
        a_len = len(A)

        # Compare adjacent list elements and exchange the
        # values if they are out of order.
        for i in range(0, a_len-1):
            for j in range(0, a_len-1-i):
                if (A[j+1] < A[j]):
                    swap(A, j, j+1)

        # Return the sorted list
        return A
