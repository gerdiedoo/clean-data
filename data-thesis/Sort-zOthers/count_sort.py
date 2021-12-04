from strategy import Order, BadOrderError, BadArgumentCombinationError
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC, is_radix:bool=False, exponent:int=None) -> list:
    """Sorts a list of characters using CountingSort.

    Sorting algorithm that is based on keys between a specific range. It counts
    the number of occurences of each element of the array (hashing-like). 
    Afterwards, the position of each object is calculated adding the 
    occurrences at each position.

    1) Store the number of occurences of each object.
    2) Modify the count array so that each element stores the sum of previos
    counts.
    3) Output each object from the input sequence and decrease its count by 1.

    DISCLAIMER: 
        When using COUNTING SORT as part of RADIX SORT, take into account that 
        the output array from this call is just a partial ordering of one digit
        at a time. Therefore, those digits need to be traversed to obtain full
        ordering of the input array.
    
    DISCLAIMER 2: 
        This implementation only allows positive integers and characters 
        sorting.

    Time Complex:
        Best    -> O(n + k); where n is the number of elements in input array
        Average -> O(n + k); where k is the range of input
        Worst   -> O(n + k)
    Space Complex (Auxiliary Space): O(n + k)
    Stable: Yes

    Args:
        array (list) -- Elements to order.
        order (Order) -- Order preference (default ASCending).
        is_radix (bool) -- This algorithm can be a subroutine for RadixSort.
        exponent (int) -- Only when is_radix=True. Radix/base being evaluated.

    Returns:
        list: Ordered elements.
    """
    # Exists the program if the ordering is not valid. 
    if (order not in [Order.ASC, Order.DESC]):
        raise BadOrderError("Not Valid Ordering Preference")

    # When using radix, exponent parameter is necessary
    if is_radix and not exponent:
        raise BadArgumentCombinationError("When using this argument as part of RadixSort, an exponent is also needed!")
    elif not is_radix and exponent:
        raise BadArgumentCombinationError("Exponent argument is not needed when not using RadixSort!")

    # Empty list
    if not array: 
        return []

    # This algorithm cannot order Strings
    if (isinstance(array[0], float)): 
        raise ValueError("This sorting algorithm does not take floating point numbers!")

    num_elems = len(array)
    # Dependending on type of list the number of buckets may vary
    # STR -> 256
    # INT -> 10
    is_str = isinstance(array[0], str)
    num_buckets = 256 if is_str else 10

    # Sorted array
    output = [0 for i in range(num_elems)]

    # Storage for the count of individual characters 
    count  = [0 for i in range(num_buckets)]

    # Count the number of appearences of each character
    for d in array:
        # Characters need to be converted to integers to be counted
        digit = ord(d) if is_str else d
        # Index to where add the count
        # When using RADIX, it is given that each value has multiple digits
        bucket = int((digit / exponent) % num_buckets) if is_radix else digit
        count[bucket] += 1

    # Each index stores the sum of the previous counts, symbolizing the index
    # of the output array
    for i in range(1, num_buckets):
        count[i] += count[i-1]

    # Build the output array
    for i in range(num_elems):
        bucket = None
        j = i
        # COUNT sort might be used as subroutine for RADIX sort
        if is_radix:
            j = (num_elems - 1) - i
            # Characters need to be converted to integers to be counted
            digit = ord(array[j]) if is_str else array[j]
            # Where to place the current element
            bucket = int((digit / exponent) % num_buckets)
        else:
            # Characters need to be converted to integers to be counted
            digit = ord(array[j]) if is_str else array[j]
            # Where to place the current element
            bucket = digit
        # Move element to output array
        output[count[bucket] - 1] = array[j] 
        count[bucket] -= 1

    # Copy sorted elements back to array, this also allows to sort the array on
    # descending order
    for i in range(num_elems):
        if (order == Order.ASC): # ASCENDING
            array[i] = output[i]
        else:                    # DESCENDING
            array[i] = output[(num_elems - 1) - i]

    return array
