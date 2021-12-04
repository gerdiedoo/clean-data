import copy
import sort_tools

def percolate_down(data, node, last_index):
    temp = data[node]

    while ( (node + 1) * 2 - 1 <= last_index ):
        child = (node + 1) * 2 - 1 #left child
        
        if child != last_index and data[child + 1] > data[child]:
            child += 1
        if data[child] > temp:
            data[node] = data[child]
        else:
            break

        node = child

    data[node] = temp

def deleteMin(data, last_index):    
    min = data[0]
    data[0] = data[last_index]
    last_index -= 1
    percolate_down(data, 0, last_index)
    data[last_index + 1] = min

def heapify(data, last_index):
    for i in range(last_index // 2, -1, -1):
        percolate_down(data, i, last_index)

def heap_sort(data):
    last_index = len(data) - 1
    
    heapify(data, last_index)

    while last_index > 0:
        deleteMin(data, last_index)
        last_index -= 1

@sort_tools.timeit('heap')
def sort(data):
    heap_sort(data)

def main():
    data = sort_tools.build_data_set(5)

    unsorted = copy.deepcopy(data)
    sort(unsorted)

if __name__ == "__main__":
    main()