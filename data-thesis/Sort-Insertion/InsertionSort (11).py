# Implementation of Insertion sort algorithm  for sorting
class InsertionSort:

    # Sort input array
    def sort(A):
        a_len = len(A)

        # Iterate over the array
        for i in range(1, a_len):
            v = A[i]
            j = i - 1
            # While index is positive and element is greater than A[i] 
            # scan and insert A[i] into its proper position.
            while((j >= 0) and A[j] > v):
                A[j+1] = A[j]
                j = j - 1
            A[j+1] = v

        # Return the sorted array
        return A
        
