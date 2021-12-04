from strategy import Order, BadOrderError
import count_sort
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC) -> list:
    """Sorts a list of floating point numbers using RadixSort.

    A sorting algorithm that uses digit by digit sorting, starting from the 
    least significant digit to the most significant digit. 
    
    DISCLAIMER: 
        This implementation only allows positive integers sorting.

    Time Complex:
        Best    -> O(n * k) where k is the number of bits required to store 
        Average -> O(n * k) each key.
        Worst   -> O(n * k)
    Space Complex (Auxiliary Space): O(n + k)
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

    # Empty list
    if not array: 
        return []

    # This algorithm cannot order Strings
    if (not isinstance(array[0], int)): 
        raise ValueError("This sorting algorithm only sorts positive integers arrays!")

    # Find maximum number to be able to compare
    max_element = max(array)

    # Perform counting sort for every digit
    pseudo_order = Order.ASC
    exponent = 1
    while (max_element // exponent) > 0:
        # When having a descending order, first the array must be ordered 
        # in ascending order (due to the structure of COUNT sort), and in the
        # last iteration it must be ordered descendingly, so that in that 
        # iteration the array is inverted with the COUNT sort call.
        if order == Order.DESC and (max_element // (exponent * 10)) <= 0:
            pseudo_order = Order.DESC
        array = count_sort.sort(array, pseudo_order, is_radix=True, exponent=exponent)
        exponent *= 10

    return array
