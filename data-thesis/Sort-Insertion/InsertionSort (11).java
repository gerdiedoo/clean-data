package src.algorithms;

import src.strategy.Order;

/**
 *
 * A sorting algorithm that virtually splits the array to order in two 
 * sub-arrays:<br>
 * <br>
 * 1) Ordered part - left-most part.<br>
 * 2) Unordered part - right-most part.<br>
 * <br>
 * The elements of 2 are picked one by one and inserted in their respective 
 * position in 1.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 *
 */
public class InsertionSort<T> extends SortingAlgorithm<T> {
	/**
     * Sorts an array of elements using Bubble Sort algorithm.
     *
     * @TimeComplexity  
     * Best    -> O(n) <br>
     * Average -> O(n²) <br>
     * Worst   -> O(n²) <br>
     *
     * @SpaceComplexity
     * O(1)
     *
     * @Stable
     * Yes
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
	public<T extends Comparable<T>> T[] sort(T[] elements, Order order) {

		int numElements = elements.length;

		// Traverse the array. On each iteration, the corresponding element is 
	    // placed at.
		for (int i=1; i<numElements; i++) {
			T edgeElement = elements[i];
			// Move elements, that are greater/smaller than the key, to one 
	        // position ahead of their current position.
			int j = i - 1;
			while (j >= 0 && (
				   order == Order.ASC  && edgeElement.compareTo(elements[j]) < 0   ||
			       order == Order.DESC && edgeElement.compareTo(elements[j]) > 0)) {
				elements[j + 1] = elements[j];
				j -= 1;
			}
			elements[j + 1] = edgeElement;
		}
		
		return elements;
	}
}
