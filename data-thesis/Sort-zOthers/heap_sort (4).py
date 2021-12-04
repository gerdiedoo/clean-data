from strategy import Order, BadOrderError
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC) ->  list:
    """Sorts a list using HeapSort.

    Sorting algorithm that uses a Binary Heap implemented on an list to sort
    elements. The smallest or largest element is found an placed at the top of 
    the heap. That process is repeated until no elements are left.
    
    1) Build a min/max heap. 
    2) Smallest/largest item is stored at the root of the heap.
       Replace the root element with the last element of the heap followed by 
       reducing the size of the heap by 1. 
       Heapify the root of the tree.
    3) Repeat 2 until the heap has size 1.

    DISCLAIMER:
        A heap is represented using an array. To do so, the two children of a 
        node use a mathematical function to find their position in the array.
        LEFT CHILD:  2 * parent_position + 1
        RIGHT CHILD: 2 * parent_position + 2

    Time Complex:
        Best    -> O(n)
        Average -> O(n log(n))
        Worst   -> O(n log(n))
    Space Complex (Auxiliary Space): O(1)
    Stable: No

    Args:
        array (list) -- Elements to order.
        order (Order) -- Order preference (default ASCending).

    Returns:
        list: Ordered elements.
    """
    # Exists the program if the ordering is not valid. 
    if (order not in [Order.ASC, Order.DESC]):
        raise BadOrderError("Not Valid Ordering Preference")
    
    num_elems = len(array)

    # Build a max/min heap
    # Heapify analyzes the children of a node. In a binary heap represented
    # using an array, that means the elements a position 2x+1 and 2x+2 (x being
    # the parent node).
    for i in range(num_elems // 2 - 1, -1, -1):
        heapify(array, num_elems, i, order)

    # Create the output array by extracting the values, in order, from the 
    # heap, doing it one by one.
    for i in range(num_elems - 1, 0, -1):
        array[i], array[0] = array[0], array[i]
        heapify(array, i, 0, order)

    return array

def heapify(array, n, i, order):
    """Process of converting a binary tree to a heap.

    Recursive process of converting a binary tree into a complete binary 
    tree. A heap must be a complete binary tree. To preserve the heap-order 
    property the value of each node must be greater or equal to its children.

    Args:
        array (list) -- Elements to order.
        n (int) -- Length of array to evaluate.
        i (int) -- Initial position (considered as parent/root).
        order (Order) -- Order preference.

    Returns:
        list: (Reference)  
    """
    largest = i
    left  = 2 * i + 1 # Left children
    right = 2 * i + 2 # Right children

    # Check if children exists and are larger/smaller than the root.
    if (left < n and (
        order == Order.ASC and array[largest] < array[left] or  # ASCENDING
        order == Order.DESC and array[largest] > array[left])): # DESCENDING
        largest = left
    if (right < n and (
        order == Order.ASC and array[largest] < array[right] or  # ASCENDING
        order == Order.DESC and array[largest] > array[right])): # DESCENDING
        largest = right

    # Change root
    if largest != i:
        array[i], array[largest] = array[largest], array[i]
        heapify(array, n, largest, order)
    
