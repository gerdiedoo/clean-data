def selectionSort(list):
    #traverse list except its last element = repeat (length - 1) times
    for i in range(0, len(list) - 1):
        #set index of minimum element in list to first element in unsorted part of list
        minimumIndex = i
        #find minimum element in unsorted part of list
        for j in range(i + 1, len(list)):
            if list[minimumIndex] > list[j]:
                minimumIndex = j
        #swap first element in unsorted part of list and minimum element in unsorted part of list
        list[i], list[minimumIndex] = list[minimumIndex], list[i]
    return list

myList = [43,54,15,13,45,87,545,435,63,245,15,753,45,2,534,15]
print(myList)
print(selectionSort(myList))