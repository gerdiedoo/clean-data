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
    """Sorts a list using BubbleSort.

    Simplest sorting algorithm that works by repeatedly swapping the 
    adjacent elements if they are in wrong order. 

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

    # Traverse the array of elements
    num_elements:int = len(array)
    for i in range(num_elements):
        swapped:bool = False

        # The last element should already be in place
        for j in range(num_elements - i - 1):
            
            # Ordering preference selection
            if   (order == Order.ASC):  # ASCENDING
                if (array[j] > array[j + 1]):
                    # Swap elements if second element is greater than first 
                    # element
                    array[j], array[j + 1] = array[j + 1], array[j]
                    swapped = True
            elif (order == Order.DESC): # DESCENDING
                if (array[j] < array[j + 1]):
                    # Swap elements if second element is smaller than first 
                    # element
                    array[j], array[j + 1] = array[j + 1], array[j]
                    swapped = True

        # HINT: If nothing is swapped, elements are already ordered. Therefore, 
        # no further ordering operations are needed
        if not swapped:
            break

    return array        
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
