from strategy import Order, Pivot, BadOrderError, BadPivotError
import random
import sys

__author__ = "Pablo Acereda"
__copyright__ = "Copyright 2020"
__credits__ = [ "Pablo Acereda" ]

__license__ = "Apache License 2.0"
__version__ = "1.0"
__maintainer__ = "Pablo Acereda"
__email__ = "p.aceredag@gmail.com"

def sort(array:list, order:Order=Order.ASC, strategy:Pivot=Pivot.MEDIAN) -> list:
    """Sorts a list using QuickSort.

    Recursive function to order elements using a pivot to redistribute the rest
    of the elements of the array at each side of that pivot.

    Time Complex:
        - Best    -> O(n log(n))
        - Average -> O(n log(n))
        - Worst   -> O(n^2)
    Space Complex (Auxiliary Space): O(log(n)). Extra space on recursion.
    Stable: No
    
    Args:
        array (list) -- Elements to order.
        order (Order) -- Order preference (default ASCending).
        strategy (Pivot) -- Pivot selection strategy (default MEDIAN).

    Returns:
        list: Ordered elements.
    """
    # Exists the program if the ordering is not valid. 
    if (order not in [Order.ASC, Order.DESC]):
        raise BadOrderError("Not Valid Ordering Preference")

    # Exists the program if the pivot is not valid. 
    if (strategy not in [Pivot.FIRST, Pivot.LAST, Pivot.RANDOM, Pivot.MEDIAN]):
        raise BadPivotError("Not valid Pivot")

    return quicksort(array, order, strategy, 0, len(array) - 1)

def quicksort(array, order, strategy, lower, upper):
    """Recursive sorting function of a list using QuickSort.

    Recursive function to order elements using pivots to redistribute the rest 
    of the elements of the array. The pivot selected is used as the center 
    element (ordering element) of the array.

    Args:
        array (list) -- List of elements.
        order (Order) -- Ordering preference: ascending/descending.
        strategy (Pivot) -- Pivot selection strategy: first/last/random/median.
        lower (int) -- Lowest index of array to reorder.
        upper (int) -- Highest index of array to reorder.

    Returns: 
        list: Ordered array.
    """
    # Recursion base condition, no more elements
    if lower > upper or not array: # Empty array
        return array

    # Define pivot depending on strategy
    pivot = None
    if (strategy == Pivot.FIRST):       # First
        pivot = lower
    elif (strategy == Pivot.LAST):      # Last
        pivot = upper
    elif (strategy == Pivot.RANDOM):    # Random
        pivot = random.randrange(lower, (upper+1))
    elif (strategy == Pivot.MEDIAN):    # Median
        pivot = _median_of_three(array, lower, upper)

    # Moves elements to the respective sides of the pivot, and returns the 
    # position of the pivot
    pivot = _partition(array, order, pivot, lower, upper)

    # Recursive call with the rest of the array
    quicksort(array, order, strategy, lower,     pivot - 1)
    quicksort(array, order, strategy, pivot + 1, upper)

    return array

def _partition(array, order, pivot, lower, upper):
    """Uses pivot to reorder elements (only orders relative to pivot, not 
    globally).

    Moves elements to their respective side of the array with the pivot as
    middle element (left for smaller/greater elements and 
    ascending/descending order; right for greater/smaller elements and 
    ascending/descending order). Returns the index of the pivot. The order of
    the list used as argument changes thanks to variable referencing.

    Args:
        array (list) -- List of elements.
        order (Order) -- Ordering preference: ascending/descending.
        pivot (Pivot) -- Index of pivot element.
        lower (int) -- Lowest index of array to reorder.
        upper (int) -- Highest index of array to reorder.

    Returns: 
        int: Index of pivot element (input array is also modified using 
        referencing).
    """
    # The pivot element is made the last not to interfere with other swaping 
    # operations
    array[pivot], array[upper] = array[upper], array[pivot]

    # Last index of smaller/greater (asc/desc) elements
    idx = lower

    for j in range(lower, upper):
        if (order == Order.ASC  and array[j] < array[upper] or # ASCENDING
            order == Order.DESC and array[j] > array[upper]):  # DESCENDING
            # Moves the current element at the end of the sub-array with
            # the smaller/grater (asc/desc) elements
            array[idx], array[j] = array[j], array[idx]
            idx += 1

    # Moves pivot as separator between greater and smaller numbers
    array[idx], array[upper] = array[upper], array[idx]

    return idx

def _median_of_three(array, lower, upper):
    """Finds median approximate median value of an array.

    Approximate the median (median value is the middle value of a sorted list 
    of elements) value using three values of a list: first, middle and last 
    elements. First and last do not need to be the absolute values, rather than
    relative values using lower and upper limit arguments. 

    Args:
        array (list) -- List of unordered elements.
        lower (int) -- Left-most element (lower limit).
        upper (int) -- Right-most element (upper limit).

    Returns: 
        int: Median element.
    """
    mid =  (lower + upper) // 2
    a = array[lower]
    b = array[mid]
    c = array[upper]
    # As only three unordered elements are passed down, the middle element must 
    # be found through comparisons
    if a <= b <= c or c <= b <= a:
        return mid
    if a <= c <= b or b <= c <= a:
        return upper

    return lower
