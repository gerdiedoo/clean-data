# author: alex o

# function call: 
# @param hi: len(arr)-1
def quick_sort(arr, lo, hi):
    # best case with DNF when all elements are the same: O(N)
    # worst case: O(N^2)
    if hi > lo:
        pivot = arr[lo]
        p = partition(arr, pivot, lo, hi)
        mid1 = p[0]
        mid2 = p[1]

        # recursively call on partition with elements < pivot
        quick_sort(arr, lo, mid1)
        # recursively call on partition with elements > pivot
        quick_sort(arr, mid2, hi)
        # print(arr)
        
    return arr

# Dutch National Flag partitioning algorithm
# all elements < pivot grouped at the left, 
# = pivot in the middle, > pivot grouped at the right
def partition(arr, pivot, lo, hi):
    if hi - lo <= 1:
        if arr[hi] < arr[lo]:
            arr[hi], arr[lo] = arr[lo], arr[hi]
        return (lo, hi)

    mid = lo
    while mid <= hi:
        if arr[mid] < pivot:
            # group all elements < pivot on the left. swap
            arr[mid], arr[lo] = arr[lo], arr[mid]
            lo += 1
            mid += 1

        elif arr[mid] == pivot:
            mid += 1

        else:
            # group all elements > pivot on the right. swap
            arr[mid], arr[hi] = arr[hi], arr[mid]
            hi -= 1

    return (lo, mid)
