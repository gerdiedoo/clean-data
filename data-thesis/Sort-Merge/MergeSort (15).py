# Implementation of Merge sort algorithm for sorting
class MergeSort:

    # Sort list
    def sort(A):

        # Merge sub-arrays B and C into A
        def merge(B, C, A):
            # Get the length of arrays B and C
            p = len(B)
            q = len(C)
            
            i = j = k = 0

            # Merge the two partitions in sorted order.
            while ((i < p) and (j < q)):
                if(B[i] <= C[j]):
                    A[k] = B[i]
                    i = i + 1
                else:
                    A[k] = C[j]
                    j = j + 1
                k = k + 1

            if(i == p):
                A[k:(p+q)] = C[j:q]
            else:
                A[k:(p+q)] = B[i:p]

        # Get the array length
        a_len = len(A)

        # Recursively call sort function for arrays
        # greater than unit-length.
        if (a_len) > 1:
            # Partition array
            B = A[0:int(len(A)/2)]
            C = A[int(len(A)/2):a_len]
            # Sort partitions B and C
            MergeSort.sort(B)
            MergeSort.sort(C)
            # Merge the sorted arrays
            merge(B,C,A)

        # Return sorted array
        return A
