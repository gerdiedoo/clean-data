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
    """Sorts a list using InsertionSort.

    A sorting algorithm that virtually splits the array to order in two 
    sub-arrays:

    1) Ordered part - left-most part.
    2) Unordered part - right-most part.

    The elements of 2 are picked one by one and inserted in their
    respective position in 1.

    Time Complex:
        Best    -> O(n)
        Average -> O(n^2)
        Worst   -> O(n^2)
    Space Complex (Auxiliary Space): O(1)
    Stable: Yes

    Args:
        array (list) -- Elements to order.
        order (Order) -- Order preference (default ASCending).

    Returns:
        list: Ordered elements.
    """
    # Exists the program if the ordering is not valid. 
    if (order not in [Order.ASC, Order.DESC]):
        raise BadOrderError("Not Valid Ordering Preference")

    # Traverse the array. On each iteration, the corresponding element is 
    # placed at 
    for i in range(1, len(array)):
        key = array[i]
        # Move elements, that are greater/smaller than the key, to one 
        # position ahead of their current position
        j = i - 1
        while (j >= 0 and 
               order == Order.ASC  and key < array[j] or # ASCENDING
               order == Order.DESC and key > array[j]):  # DESCENDING
            array[j + 1] = array[j]
            j -= 1
        array[j + 1] = key

    return array
