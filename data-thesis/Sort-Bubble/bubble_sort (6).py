# author: alex o

def bubble_sort(arr):
    # best case: O(N). stop sorting when the list is already sorted.
    # worse case: O(N^2)

    for mark in range(len(arr)-1, 0, -1):
        swapped = False
        for i in range(mark):
            if arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
                swapped = True

        # print(arr)

        if not swapped:
            break
            
    return arr
