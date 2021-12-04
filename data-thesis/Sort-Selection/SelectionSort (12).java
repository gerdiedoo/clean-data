package src.algorithms;

import src.strategy.Order;

/**
 * A sorting algorithm that sorts a given array by finding the minimum element
 * (with ascending order). Afterwards, it moves the array to another sub-array
 * containing the ordered subset. That means that two sub-arrays are needed(1):
 *
 * 1) Sub-array sorted subset.
 * 2) Remaining unsorted sub-array.
 *
 * (1) - In this implementation they are inside original array.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 */
public class SelectionSort<T> extends SortingAlgorithm<T> {

	/**
	 * Sorts an array of elements using Selection Sort algorithm.
	 *
	 * @TimeComplexity
	 * Best    -> O(n²) <br>
	 * Average -> (n²) <br>
	 * Worst   -> (n²) <br>
	 *
	 * @SpaceComplexity
	 * O(1)
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
		int numElements = elements.length;
		for (int i=0; i<numElements-1; i++) {
			int posEdgeElement = i;
			for (int j=i+1; j<numElements; j++) {
				if ((order == Order.ASC  && elements[posEdgeElement].compareTo(elements[j]) > 0)  ||
					(order == Order.DESC && elements[posEdgeElement].compareTo(elements[j]) < 0)) {
					posEdgeElement = j;
				}
			}
			swap(elements, i, posEdgeElement);
		}
		
		return elements;
	}
	
}
