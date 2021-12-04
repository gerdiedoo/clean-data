import time

#[attribution]: https://stackoverflow.com/questions/5478351/python-time-measure-function
def timing(f):
    #@functools.wraps(f)
    def wrap(*args, **kwargs):
        time1 = time.time()
        ret = f(*args, **kwargs)
        time2 = time.time()
        print('{:s} function took {:.3f} ms'.format(f.__name__, (time2-time1)*1000.0))

        return ret
    return wrap

def swap(arr, a, b):
    arr_cp = arr
    temp = arr_cp[a]
    arr_cp[a] = arr_cp[b]
    arr_cp[b] = temp
    return arr_cp

# Bubble sort
# Compare each pair of items and swap them if they're in the wrong order.
# Not great - can be quite slow
# O(n^2)
@timing
def bubble_sort(arr):
    arr_cp = arr
    for i in range(len(arr_cp), 0, -1):
        for j in range(1, i):
            if (arr_cp[j-1] > arr[j]):
                #print("Swapping indexes {} and {}".format(j, j-1))
                arr_cp = swap(arr_cp, j-1, j)
    return arr_cp

# Selection sort
# Find the largest number and move it to the end, and repeat
# O(n^2)
@timing
def selection_sort(arr):
    arr_cp = arr
    length = len(arr_cp)
    for i in range(0, length):
        last_index = (length - 1) - i

        # Find largest number
        max_index = 0
        for j in range(0, last_index):
            if (arr_cp[j] > arr[max_index]):
                max_index = j

        arr_cp = swap(arr_cp, max_index, last_index)
    return arr_cp


# Insertion sort
# Same premise as bubble sort: swaps consecutive pairs.
# However, it skips more unnecessary checks and extra swaps,
# which helps to make it faster
# Worst case: sorted in descending order - O(N^2)
@timing
def insertion_sort(arr):
    arr_cp = arr
    for i in range(0, len(arr_cp) - 1):
        for j in range(i+1, 0, -1):
            if (arr_cp[j-1] > arr_cp[j]):
                arr_cp = swap(arr_cp, j-1, j)
            else:
                break

    return arr_cp

# Python's built-in sorting algorithm
@timing
def python_sort(arr):
    return sorted(arr)
        

# Insert any array of numbers here!
l = [555,510,20,5,78,3,4557,23,467,12789,663,41,21, 20329, 3141219, ]

print(bubble_sort(l))
print(selection_sort(l))
print(insertion_sort(l))
print(python_sort(l));

