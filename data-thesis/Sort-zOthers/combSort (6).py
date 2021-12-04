# Comb Sort is an improvement of Bubble Sort which compares two adjacent numbers in every iteration through list.
# Comb Sort compares two numbers across specified gap. It starts with a large gap and shrinks the gap after every
# iteration through the list. The optimal shrink factor was found experimentally and it is 1.3.
# It improves performance on the worst case of Bubble Sort - having small numbers at the end of the list. Having
# gap larger than one requires less comparisons than when the gap is 1.
#
# Time Complexity: Worst-Case O(n^2), Best-Case O(n*log(n))
# Space Complexity: O(1), In-Place
# Stability: Stable

def combSort(list):
    # set initial gap to length of list
    gap = len(list)
    # repeat while gap is not 1 or no two elements were swapped during iteration
    while gap > 1:
        # update gap
        gap = int(gap / 1.3)
        # iterate through list
        for i in range(len(list) - gap):
            # if current number is larger than number across the gap
            if list[i] > list[i + gap]:
                # set swapped to true and swap the numbers
                list[i], list[i + gap] = list[i + gap], list[i]
    return list

myList = [343,12,45,13,87,45,25,665,5,234,6,23,5]
print(myList)
print(combSort(myList))
