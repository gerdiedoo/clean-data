from strategy import Order, BadOrderError
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC) -> list:
    """Sorts a list using SelectionSort.

    A sorting algorithm that sorts a given array by finding the minimum 
    element (with ascending order). It then moves the array to another
    sub-array containing the ordered subset. That means that two sub-arrays
    are needed.
    
    1) Sub-array sorted subset.
    2) Remaining unsorted sub-array.

    Time Complex:
        - Best    -> O(n^2)
        - Average -> O(n^2)
        - Worst   -> O(n^2)
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

    # In every iteration of selection sort, the minimum/maximum element 
    # (depending on ordering) from the unsorted sub-array is picked and moved 
    # to the sorted sub-array - in this code, the left-most part of the array.
    for i in range (len(array)):
        idx = i

        # Look for the minimum/maximum (ascending/descending) element of the
        # unordered array.
        for j in range(i + 1, len(array)):
            # Ordering preference selection
            if   (order == Order.ASC):  # ASCENDING
                if (array[idx] > array[j]): 
                    idx = j
            elif (order == Order.DESC): # DESCENDING
                if (array[idx] < array[j]):
                    idx = j

        # Swap elements with the first element of the unordered sub-array, 
        # now the last position of the ordered sub-array.
        array[i], array[idx] = array[idx], array[i]

    return array
