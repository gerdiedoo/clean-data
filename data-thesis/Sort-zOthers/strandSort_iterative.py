def strandSort(inputList):
    #create outputList
    outputList = []
    #create sublist
    sublist = []
    #while inputList is not empty
    while inputList:
        #move first item of inputList to sublist
        sublist.append(inputList[0])
        del inputList[0]
        #traverse inputList
        index = 0
        while index < len(inputList):
            #if current number is greater than last number in sublist, move number from inputList to sublist
            if inputList[index] > sublist[-1]:
                sublist.append(inputList[index])
                del inputList[index]
                index -= 1
            index += 1
        #merge sublist into outputList
        outputList = merge(sublist, outputList)
        del sublist[:]
    return outputList

#merge two lists already sorted in increasing order into one list sorted in increasing order
def merge(list1, list2):
    indexList1 = 0
    indexList2 = 0
    outputList = []
    #while indexList1 is not equal to length of list1 and indexList2 is not equal to length of list2
    while indexList1 != len(list1) and indexList2 != len(list2):
        #if number at indexList1 in list 1 is smaller than number at indexList2 in list 2
        if list1[indexList1] < list2[indexList2]:
            #append current number at indexList1 in list 1 to outputList and increase indexList1 by 1
            outputList.append(list1[indexList1])
            indexList1 += 1
        #otherwise, append number at indexList2 in list 2 to outputList and increase indexList2 by 1
        else:
            outputList.append(list2[indexList2])
            indexList2 += 1
    #if there are any numbers left in list 1, append them to output list
    while indexList1 != len(list1):
        outputList.append(list1[indexList1])
        indexList1 += 1
    #if there are any numbers left in list 2, append them to output list
    while indexList2 != len(list2):
        outputList.append(list2[indexList2])
        indexList2 += 1
    return outputList

myList = [43, 54, 15, 13, 45, 87, 545, 435, 63, 245, 15, 753, 45, 2, 534, 15]
print(myList)
print(strandSort(myList))
