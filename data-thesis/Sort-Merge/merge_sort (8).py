# author: alex o
# https://en.wikipedia.org/wiki/Merge_sort

def merge_sort(arr):
    # base case. list = 0 or 1 elements
    if len(arr) <= 1:
        return arr

    # recursive case. divide the list into 2 equal sized sublists
    left = []
    right = []
    for i in range(len(arr)):
        if i < len(arr)//2:
            left.append(arr[i])
        else:
            right.append(arr[i])

    # recursively sort both sublists
    left = merge_sort(left)
    right = merge_sort(right)
    
    # print(arr)
    # merge the sorted sublists
    return merge(left, right)

def merge(left, right):
    # merge sublists while sorting 
    result = []

    l = 0
    r = 0

    while l < len(left) and r < len(right):
        if left[l] <= right[r]:
            result.append(left[l])
            l += 1
        else:
            result.append(right[r])
            r += 1

    # either left or right sublist have elements left
    while l < len(left):
        result.append(left[l])
        l += 1
    while r < len(right):
        result.append(right[r])
        r += 1

    return result
