#!/usr/bin/env python
#
# Mehmet Dursun INCE 26.03.2013 
#
# Using quick sort algorithm in huge data stack.
#
# http://hetland.org/coding/python/quicksort.html
import time
numbers = []

def partition(list, start, end):
    pivot = list[end]                          # Partition around the last value
    bottom = start-1                           # Start outside the area to be partitioned
    top = end                                  # Ditto

    done = 0
    while not done:                            # Until all elements are partitioned...

        while not done:                        # Until we find an out of place element...
            bottom = bottom+1                  # ... move the bottom up.

            if bottom == top:                  # If we hit the top...
                done = 1                       # ... we are done.
                break

            if list[bottom] > pivot:           # Is the bottom out of place?
                list[top] = list[bottom]       # Then put it at the top...
                break                          # ... and start searching from the top.

        while not done:                        # Until we find an out of place element...
            top = top-1                        # ... move the top down.
            
            if top == bottom:                  # If we hit the bottom...
                done = 1                       # ... we are done.
                break

            if list[top] < pivot:              # Is the top out of place?
                list[bottom] = list[top]       # Then put it at the bottom...
                break                          # ...and start searching from the bottom.

    list[top] = pivot                          # Put the pivot in its place.
    return top                                 # Return the split point

def quicksort(list, start, end):
    if start < end:                            # If there are two or more elements...
        split = partition(list, start, end)    # ... partition the sublist...
        quicksort(list, start, split-1)        # ... and sort both halves.
        quicksort(list, split+1, end)
    else:
        return

def read_from_file(filepath):
    del numbers[:] # Listeyi temizle
    file = open(filepath, "r")
    for i in file:
        numbers.append(int(i))

def print_first_ten_number():
    print numbers[0:9]
        
def print_last_ten_number():
    print numbers[len(numbers)-10:len(numbers)]

def append_result_to_file(str):
    with open("results.txt", "a") as result:
        result.write(str+"\n")
        result.close()
    
if __name__=="__main__":                       # If this script is run as a program:
    #1k
    read_from_file("../1k.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("1k = " + str(end-start))
    #10k
    read_from_file("../10k.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("10k = " + str(end-start))
    #100k
    read_from_file("../100k.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("100k = " + str(end-start))
    #1m
    read_from_file("../1m.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("1m = " + str(end-start))
    #2m
    read_from_file("../2m.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("2m = " + str(end-start))     
    #4m
    read_from_file("../4m.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("4m = " + str(end-start))
    #8m
    read_from_file("../8m.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("8m = " + str(end-start))
    #10m
    read_from_file("../10m.lst")
    start = time.clock()
    quicksort(numbers,0,len(numbers)-1)
    end = time.clock()
    append_result_to_file("10m = " + str(end-start))    
