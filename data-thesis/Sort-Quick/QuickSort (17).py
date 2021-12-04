# Implementation of Quick sort algorithm for sorting
class QuickSort:

    # Sort input array
    def sort(A):
        # If array is unit length, then return.
        if(len(A) <= 1):
            return A

        else:
            # Generate three sub-arrays
            lt = []
            eq = []
            gt = []

            # Get the pivot
            p = A[0]

            # Iterate through the array elements
            for i in range(0, len(A)):
                # Element is less than pivot
                if (A[i] < p):
                    lt.append(A[i])
                # Element is equal to pivot
                elif (A[i] == p):
                    eq.append(A[i])
                # Element is greater than pivot
                else:
                    gt.append(A[i])

            # Sort the partitions
            lt = QuickSort.sort(lt)
            eq = QuickSort.sort(eq)
            gt = QuickSort.sort(gt)

            # Return the merged array
            return lt + eq + gt
