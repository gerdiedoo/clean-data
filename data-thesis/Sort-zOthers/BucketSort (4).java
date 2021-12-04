package src.algorithms;

import java.util.Arrays;
import java.util.Vector;

import src.exceptions.BadArgumentTypeException;
import src.exceptions.NotEnoughBucketsException;
import src.strategy.Order;

/**
*
* An algorithm that distributes the elements into a number of buckets. Each 
* bucket is sorted individually (in this case, using InsertionSort). Afterwards,
* each bucket is ordered.
*
* 1) Create empty buckets (lists).
* 2) Insert elements in into bucket [ n * array[i] ].
* 3) Sort individual buckets with InsertionSort.
* 4) Concatenate buckets.
*
* DISCLAIMER:
* 	This version of the algorithm only sorts floating point numbers.
*
* @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
* @version: 1.0
* @license: Copyright 2021 © Pablo Acereda
* License under Apache License, Version 2.0
*
* @param <T> Primitive datatype or object.
*
*/
public class BucketSort<T> extends SortingAlgorithm<T> {

	private InsertionSort<T> insertionSort = new InsertionSort<>();

	/**
	 * Sorts an array of elements using Bucket Sort algorithm.
	 *
	 * @TimeComplexity
	 * Best    -> O(n + k) <br>
	 * Average -> k being the number of buckets: <br> 
	 * 			  O(n + k) when n~k <br>
	 *            O(n + n²/k + k) when otherwise <br>
	 * Worst   -> O(n²) <br>
	 *
	 * @SpaceComplexity
	 * O(n * k)
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
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order) 
			throws Exception {

		return this.sort(elements, order, elements.length);
	}

	/**
	 * Sorts an array of elements using Bucket Sort algorithm.
	 *
	 * @TimeComplexity
	 * Best    -> O(n + k) <br>
	 * Average -> O() <br>
	 * Worst   -> O(n²) <br>
	 *
	 * @SpaceComplexity
	 * O(n * k)
	 *
	 * @Stable
	 * Yes
	 *
	 * @param <T> Primitive datatype or object.
     *
     * @param elements Elements to be ordered.
     * @param order Order preference.
     * @param numSlots Number of buckets. Suggest using number of elements.
     *
     * @return Sorted array.
     *
	 * @throws Exception 
	 */
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order, int numSlots) 
			throws  Exception {
		if (elements.length == 0 || elements == null) 
			return elements;

		if (!(elements[0] instanceof Float)) {
			throw new BadArgumentTypeException("This implementation of Bucket Sort is only prepared for Float elements!");
		}

		if (numSlots <= 0) {
			throw new NotEnoughBucketsException("There must be at least one bucket to be able to execute this sorting algorithm!");
		}

		// Create buckets 
		@SuppressWarnings("unchecked")
		Vector<T>[] buckets = new Vector[numSlots];
		for (int i=0; i < numSlots; i++) {
			buckets[i] = new Vector<T>();
		}

		// Distribute elements through buckets
		for (int i=0; i < elements.length; i++) {
			int idx = (int) ((float) elements[i] * numSlots);
			buckets[idx - 1].add(elements[i]);
		}

		// Sort each bucket individually
		for (int i=0; i < numSlots; i++) {
			T[] sorted = this.insertionSort.<T>sort(this.transformToArray(elements, buckets[i]));
			buckets[i] = this.transformToVector(sorted);
		}

		// Concatenate buckets
		int k = 0;
		for (Vector<T> bucket : buckets) {
			for (T elem : bucket) {
				if (order == Order.ASC) { // ASCENDING
					elements[k] = elem;
				} else {                  // DESCENDING
					elements[elements.length - 1 - k] = elem;
				}
				k += 1;
			}
		}

		return elements;
	}

	/**
	 * Transform Generic Vector to Generic Array.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param base   Generic Array base to use to transform as Array. 
	 * @param toCopy Data to copy to Array.
	 *
	 * @return Generic Array from Vector.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> T[] transformToArray(T[] base, Vector<T> toCopy) {
		T[] a = Arrays.copyOf(base, toCopy.size());
		for (int i=0; i < toCopy.size(); i++) {
			a[i] = toCopy.get(i);
		}

		return a;
	}

	/**
	 * Transform Generic Array to Generic Vector.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param toCopy Data to copy to Vector.
	 *
	 * @return Generic Vector from Array.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> Vector<T> transformToVector(T[] toCopy) {
		Vector<T> a = new Vector<T>();
		for (T elem : toCopy) {
			a.add(elem);
		}

		return a;
	}
}
