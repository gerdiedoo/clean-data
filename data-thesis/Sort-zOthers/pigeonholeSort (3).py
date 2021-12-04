# Pigeonhole Sort should be used when number of elements in list and range of the elements are approximately the same.
# It first finds min and max in the list and computes range of numbers in list. Then it sets up a pigeonhole list and
# copies elements to it - element is put into (element - min) place in pigeonhole list. After that, it loops through
# pigeonhole list and puts elements back to the original list keeping the order they had in pigeonhole list.
# Pigeonhole Sort and Counting Sort are similar, but not the same. Pigeonhole Sort first moves elements to pigeonhole list
# and then from pigeonhole list to the final destination in the original list. Counting Sort uses second list to count
# occurrences of each element in the list and then uses it to compute each element's destination in the original list.
#
# Time Complexity: O(n + range) where range is (max - min + 1)
# Space Complexity: O(n + range), Out Of Place
# Stability: Stable

def pigeonholeSort(list):
    # find minimum and maximum number in list
    min = list[0]
    max = list[0]
    for n in list:
        if min > n:
            min = n
        if max < n:
            max = n
    # find range of numbers in list
    listRange = max - min + 1
    # set up list of lists of same size as range
    pigeonholeList = [[] for i in range(listRange)]
    # iterate through numbers in the list
    for n in list:
        # find index at which to insert number
        index = n - min
        # append number to list that is at index place in pigeonholeList
        pigeonholeList[index].append(n)
    # set index of list to 0
    indexList = 0
    # loop through sublists in pigeonholeList
    for l in pigeonholeList:
        # loop through numbers in sublist
        for n in l:
            # copy number to indexList place in list
            list[indexList] = n
            # add 1 to index of list
            indexList += 1
    return list

list = [3,5,3,1,6,8,5,2,8,9,6,5,7]
print(list)
print(pigeonholeSort(list))