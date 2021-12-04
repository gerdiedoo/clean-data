    from strategy import Order, BadOrderError
import insertion_sort
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC, num_slots:int=10) -> list:
    """Sorts a list of floating point numbers using BucketSort.

    An algorithm that distributes the elements into a number of buckets. Each
    bucket is sorted individually (in this case, using InsertionSort). 
    Afterwards, each bucket is ordered.

    1) Create empty buckets (lists).
    2) Insert elements in into bucket [ n * array[i] ].
    3) Sort individual buckets with InsertionSort.
    4) Concatenate buckets.

    DISCLAIMER:
        This version of the algorithm only sorts floating point numbers.

    Time Complex:
        Best    -> O(n + k)
        Average -> k being the number of buckets.
            O(n + k)        when n~k
            O(n + n^2/k + k) when otherwise 
        Worst   -> O(n^2)
    Space Complex (Auxiliary Space): O(n * k)
    Stable: Yes

    Args:
        array (list) -- Elements to order.
        order (Order) -- Order preference (default ASCending).
        num_slots (int) -- Number of buckets (default 10).

    Returns:
        list: Ordered elements.
    """
    # Exists the program if the ordering is not valid. 
    if (order not in [Order.ASC, Order.DESC]):
        raise BadOrderError("Not Valid Ordering Preference")

    # Empty list
    if not array: 
        return []

    # This algorithm cannot order Strings
    if (type(array[0]) is str): 
        raise ValueError("This sorting algorithm does not take Strings!")

    # Create empty buckets
    slots = []
    for _ in range(num_slots):
        slots.append([]) # Exists the program if the ordering is not valid.

    # Place elements in buckets
    for elem in array: 
        if (elem >= 1):
            raise ValueError("This sorting algorithm only works for floating point numbers!")

        index_b = int(num_slots * elem)
        slots[index_b - 1].append(elem) 

    # Order each slot using insertion sort
    for i in range(num_slots):
        slots[i] = insertion_sort.sort(slots[i])

    # Concatenate sorted buckets
    k = 0
    for bucket in slots:
        for item in bucket:
            if (order == Order.ASC): # ASCENDING
                array[k] = item
            else:                    # DESCENDING
                array[(len(array) - 1) - k] = item
            k += 1

    return array
