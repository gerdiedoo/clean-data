#!/usr/bin/env python
#
# Mehmet Dursun INCE 26.03.2013 
#
# Using quick sort algorithm in huge data stack.
#
# http://rosettacode.org/wiki/Sorting_algorithms/Heapsort#Python
import time
numbers = []

def heap_sort(lst):
  ''' Heapsort. Note: this function sorts in-place (it mutates the list). '''
 
  # in pseudo-code, heapify only called once, so inline it here
  for start in range((len(lst)-2)/2, -1, -1):
    siftdown(lst, start, len(lst)-1)
 
  for end in range(len(lst)-1, 0, -1):
    lst[end], lst[0] = lst[0], lst[end]
    siftdown(lst, 0, end - 1)
 
def siftdown(lst, start, end):
  root = start
  while True:
    child = root * 2 + 1
    if child > end: break
    if child + 1 <= end and lst[child] < lst[child + 1]:
      child += 1
    if lst[root] < lst[child]:
      lst[root], lst[child] = lst[child], lst[root]
      root = child
    else:
      break
        
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
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("1k = " + str(end-start))
    #10k
    read_from_file("../10k.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("10k = " + str(end-start))
    #100k
    read_from_file("../100k.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("100k = " + str(end-start))
    #1m
    read_from_file("../1m.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("1m = " + str(end-start))
    #2m
    read_from_file("../2m.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("2m = " + str(end-start))     
    #4m
    read_from_file("../4m.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("4m = " + str(end-start))
    #8m
    read_from_file("../8m.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("8m = " + str(end-start))
    #10m
    read_from_file("../10m.lst")
    start = time.clock()
    heap_sort(numbers)
    end = time.clock()
    append_result_to_file("10m = " + str(end-start))     
