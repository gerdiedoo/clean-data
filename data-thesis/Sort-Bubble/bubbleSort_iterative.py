# Bubble sort is a sorting algorithm that iterates through list and swaps two adjacent numbers if they are in wrong order.
# It keeps iterating until no two numbers were swapped during previous iteration.
# It can be optimized by noticing that n-th iteration finds n-th largest number and places it to the right position.
# Therefore, the next iteration needs to check and swap only numbers in 0 to n-1 (exclusive) positions.
#
# Time Complexity: Worst-Case O(n^2), Best-Case O(n)
# Space Complexity: O(1), In-Place
# Stability: Stable

def bubbleSort(list):
    # how many numbers are not sorted yet
    notSorted = len(list)
    swapped = True
    # repeat while numbers were swapped
    while swapped:
        # clear swapped variable
        swapped = False
        # goes through unsorted elements
        for i in range(0, notSorted - 1):
            # if element on the left is larger, swap left and right elements
            if list[i] > list[i + 1]:
                list[i], list[i + 1] = list[i + 1], list[i]
                swapped = True
        # update number of unsorted elements
        notSorted -= 1
    return list

myList = [43,54,15,13,87,545,435,63,245,753,45,2,534,15]
print(myList)
print(bubbleSort(myList))
