package src.algorithms;

import java.util.Arrays;

import src.strategy.Order;

/**
 *
 * Recursive function to order elements by dividing the input array into two 
 * halves, making one recursive call per half, and the merging the returned 
 * elements into an ordered array.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 *
 */
public class MergeSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	/**
	 * Sorts an array of elements using Merge Sort algorithm.
	 *
	 * @TimeComplexity  
     * Best    -> O(log(n)) <br>
     * Average -> O(log(n)) <br>
     * Worst   -> O(log(n)) <br>
     * 
     * @SpaceComplexity
     * O(n). That extra space goes into the recursion.
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
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order) {
		return this.mergesort(elements, order);
	}

	/**
	 * Recursive function where an array is splitted into two separate parts
	 * (divided in the middle) and then merged ordering the two independent 
	 * parts into a new ordered array.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements List of elements to order.
	 * @param order Order preference: ascending/descending.
	 *
	 * @return Ordered array.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> T[] mergesort(T[] elements, Order order) {
		if (elements.length <= 1) {
			return elements;
		}

		// Middle element, to split the array.
		int middlePos = elements.length / 2;

		// Recursive call to order each half.
		T[] left  = Arrays.copyOfRange(elements, 0,         middlePos);
		T[] right = Arrays.copyOfRange(elements, middlePos, elements.length);

		left  = this.mergesort(left,  order);
		right = this.mergesort(right, order);

		// Merge parts respecting order.
		return this.merge(elements, left, right, order);
	}

	/**
	 * Merges the two arrays passed as parameter into an ordered array. Assumes
	 * that the input arrays are ordered.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements Array containing all elements.
	 * @param arr1 First ordered array.
	 * @param arr2 Second ordered array.
	 * @param order Order preference: ascending/descending.
	 *
	 * @return Ordered union of both input array.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> T[] merge(T[] elements, T[] arr1, T[] arr2, Order order) {
		// i for arr1; j for arr2.
		int i = 0;
		int j = 0;
		int k = 0;

		int n = arr1.length + arr2.length;
		T[] sortedArray = Arrays.copyOf(elements, n);

		while (i < arr1.length && j < arr2.length) {
			if        (order == Order.ASC) {  // ASCENDING
				if (arr1[i].compareTo(arr2[j]) <= 0) {
					sortedArray[k] = arr1[i];
					i++;
				} else {
					sortedArray[k] = arr2[j];
					j++;
				}
			} else if (order == Order.DESC) { // DESCENDING
				if (arr1[i].compareTo(arr2[j]) >= 0) {
					sortedArray[k] = arr1[i];
					i++;
				} else {
					sortedArray[k] = arr2[j];
					j++;
				}
			}
			k++;
		}

		// Include elements left in arrays.
		while (i < arr1.length) {
			sortedArray[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			sortedArray[k] = arr2[j];
			j++;
			k++;
		}

		return sortedArray;
	}
}
