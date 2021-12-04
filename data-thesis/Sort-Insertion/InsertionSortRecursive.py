#! /usr/bin/python3

from random import randint
import time

#####
# Recursive Insertion Sort
#####
def insertionSortRecursive(list):
    j = 1
    return insertionSortRecursiveAction(list, j)

def insertionSortRecursiveAction(list, j):
    if (j < len(list)):
        key = list[j]
        i = j - 1
        list, i = insertRecursive(list, key, i)
        list[i + 1] = key
        j = j + 1
        list = insertionSortRecursiveAction(list, j)
    return list

def insertRecursive(list, key, i):
    if (i >= 0 and list[i] > key):
        list[i + 1] = list[i]
        i = i - 1
        list, i = insertRecursive(list, key, i)
    return list, i



#####
#Iterative Insertion Sort
#####
def insertionSortIterative(list):
    for j in range(1, len(list)):
        key = list[j]
        i = j - 1
        list, i = insertIterative(list, key, i)
        list[i + 1] = key
    #for j
    return list
#insertionSort

def insertIterative(list, key, i):
    while (i >= 0 and list[i] > key):
        list[i + 1] = list[i]
        i = i - 1
    #while
    return list, i
#insert

for i in range(0, 10):
    list = []
    for num in range(0, 100):
        list.append(randint(0, 100))
    #for num
    #print(list)
    #print(insertionSort(list))
    #print()
    
    iterativeStart = 0
    iterativeStop = 0  
    iterativeStart = time.clock()
    insertionSortIterative(list)
    iterativeStop = time.clock()
    iterativeTime = 1000000 * (iterativeStop - iterativeStart)
    print("Iterative: " + str(iterativeTime))

    recursiveStart = 0
    recursiveStop = 0
    recursiveStart = time.clock()
    insertionSortRecursive(list)
    recursiveStop = time.clock()
    recursiveTime = 1000000 * (recursiveStop - recursiveStart)
    print("Recursive: " + str(recursiveTime))

    print("Speedup: " + str(iterativeTime / recursiveTime))
    print()
#for i

list = []
for num in range(0, 100):
    list.append(randint(0, 100))
#for num

print(list)
print(insertionSortRecursive(list))
print()
