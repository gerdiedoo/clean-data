# Bubble sort is a sorting algorithm that iterates through list and swaps two adjacent numbers if they are in wrong order.
# It keeps iterating until no two numbers were swapped during previous iteration.
# It can be optimized by noticing that n-th iteration finds n-th largest number and places it to the right position.
# Therefore, the next iteration needs to check and swap only numbers in 0 to n-1 (exclusive) positions.
#
# Time Complexity: Worst-Case O(n^2), Best-Case O(n)
# Space Complexity: O(1), In-Place
# Stability: Stable

# parameters - unsorted list
#            - number of unsorted numbers in the list counted from the beginning of list (list length in the first call)
def bubbleSort(list, notSorted):
    swapped = False
    # goes through unsorted numbers
    for i in range(0, notSorted - 1):
        # if numbers on the left is larger, swap left and right numbers
        if list[i] > list[i + 1]:
            list[i], list[i + 1] = list[i + 1], list[i]
            swapped = True
    # base case - if nothing was swapped, return sorted list
    if swapped == False:
        return list
    # recursive call - if there was a swap, call bubbleSort with updated number of not sorted numbers
    else:
        return bubbleSort(list, notSorted - 1)

myList = [43,54,15,13,87,545,435,63,245,753,45,2,534,15]
print(myList)
print(bubbleSort(myList, len(myList)))