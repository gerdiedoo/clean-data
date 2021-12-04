package src.algorithms;

import src.strategy.Order;
import src.strategy.Pivot;

/**
 *
 * Recursive function to order elements using a pivot to redistribute the rest of
 * the elements of the array at each side of that pivot.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 *
 */
public class QuickSort<T> extends SortingAlgorithm<T> {

	/**
	 * Sorts an array of elements using Quick Sort algorithm, with the median 
	 * for pivoting.
	 *
	 * @TimeComplexity  
     * Best    -> O(log(n)) <br>
     * Average -> O(log(n)) <br>
     * Worst   -> O(n²) <br>
     *
     * @SpaceComplexity
     * O(log(n)). That extra space goes into the recursion.
     *
     * @Stable
     * No
     *
     * @param <T> Primitive datatype or object.
     *
     * @param elements Elements to be ordered.
     * @param order Order preference.
     *
     * @return Sorted array.
	 */
	@Override
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order) {
		return this.sort(elements, order, Pivot.MEDIAN);
	}
	
	/**
	 * Sorts an array of elements using Quick Sort algorithm, with the median 
	 * for pivoting.
	 *
	 * @TimeComplexity  
     * Best    -> O(log(n)) <br>
     * Average -> O(log(n)) <br>
     * Worst   -> O(n²) <br>
     *
     * @SpaceComplexity
     * O(log(n)). That extra space goes into the recursion.
     *
     * @Stable
     * No
     *
     * @param <T> Primitive datatype or object.
     *
     * @param elements Elements to be ordered.
     * @param order Order preference.
     * @param pivot Pivot selection strategy.
     *
     * @return Sorted array.
	 */
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order, Pivot pivot) {
		return this.quicksort(elements, order, pivot, 0, elements.length-1);
	}
	
	/**
	 * Recursive function to order elements using pivot to redistribute the rest
	 * of the elements of the array. The pivot selected is used as the center 
	 * element (ordering element) of the array.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements List of elements.
	 * @param order Ordering preference: ascending/descending.
	 * @param pivot Index of pivot element.
	 * @param lowerPos Lowest index of array to re-oder.
	 * @param upperPos Highest index of array to re-oder.
	 *
	 * @return Sorted array.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> T[] quicksort(T[] elements, Order order, Pivot pivot, int lower, int upper) {
		// Stop conditions
		if (lower > upper || elements.length == 0 || elements == null) {
			return elements;
		}

		// Define pivot depending on strategy.
		int p;
		if        (pivot == Pivot.FIRST) {  // First
			p = lower;
		} else if (pivot == Pivot.LAST) {   // Last
			p = upper;
		} else if (pivot == Pivot.RANDOM) { // Random 
			p = (int) (Math.random() * (upper-lower+1) + lower);
		} else {                            // Median
			p = this.medianOfThree(elements, lower, upper);
		}

		// Moves elements to the respective sides of the pivot, and returns the
		// position of the pivot.
		p = this.partition(elements, order, p, lower, upper);

		// Recursive call with the rest of the array.
		quicksort(elements, order, pivot, lower, p - 1);
		quicksort(elements, order, pivot, p + 1, upper);

		return elements;
	}
	
	/**
	 * Moves elements to their respective side of the array with the pivot as 
	 * middle element (left for smaller/greater elements and
	 * ascending/descending order; right for greater/smaller elements and 
	 * ascending/descending order).
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements List of elements.
	 * @param order Ordering preference: ascending/descending.
	 * @param pivot Index of pivot element.
	 * @param lowerPos Lowest index of array to reoder.
	 * @param upperPos Highest index of array to reoder.
	 *
	 * @return Index of the pivot elements (input array is also modified using 
	 * referencing).
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> int partition(T[] elements, Order order, int pivot, int lowerPos, int upperPos) {
		// The pivot element is made the last element no to interfere with other
		// swapping operations.
		this.swap(elements, pivot, upperPos);

		// Last index of smaller/greater (asc/desc) elements.
		int idx = lowerPos;

		for (int j=lowerPos; j<upperPos; j++) {
			if ((order == Order.ASC  && elements[j].compareTo(elements[upperPos]) < 0)  || 
				(order == Order.DESC && elements[j].compareTo(elements[upperPos]) > 0)) {
				// Moves the current element at the end of the sub-array with
				// the smaller/greater (asc/desc) elements.

				this.swap(elements, idx, j);
				idx++;
			}
		}
		// Moves pivot as separator between greater and smaller numbers.
		this.swap(elements, idx, upperPos);

		return idx;
	}

	/**
	 * Approximate the median (median value is the middle value of a sorted list
	 * of elements) value using three values of a list: first, middle and last
	 * elements. First and last do not need to be the absolute values, rather
	 * than relative values using lower and upper limit arguments.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements List of unordered elements.
	 * @param lowerPos Left-most element (lower limit).
	 * @param upperPos Right-most element (upper limit).
	 *
	 * @return Median element.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> int medianOfThree(T[] elements, int lowerPos, int upperPos) {
		int middlePos = (lowerPos + upperPos) / 2;
		T a = elements[lowerPos];
		T b = elements[middlePos];
		T c = elements[upperPos];
		// As only three unordered elements are passed down, the middle element 
		// must be found through comparisons.
		if ((a.compareTo(b) <= 0 && b.compareTo(c) <= 0)  || 
			(c.compareTo(b) <= 0 && b.compareTo(a) <= 0)) {
			return middlePos;
		}
		
		if ((a.compareTo(c) <= 0 || c.compareTo(b) <= 0)  && 
			(b.compareTo(c) <= 0 || c.compareTo(a) <= 0)) {
			return upperPos;
		}

		return lowerPos;
	}

}
