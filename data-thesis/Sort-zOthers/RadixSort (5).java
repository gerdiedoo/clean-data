package src.algorithms;

import src.exceptions.BadArgumentTypeException;
import src.exceptions.BadRadixArgumentException;
import src.strategy.Order;

/**
 *
 * Sorting algorithm that uses digit by digit sorting (CountSort), starting from
 * the least significant digit to the most significant digit.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 *
 */
public class RadixSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	/**
	 * Sorts an array of elements using Radix Sort algorithm.
	 * <br>
	 * DISCLAIMER: This implementation only supports positive integers sorting
	 * and strings sorting.
	 *
	 * @TimeComplexity
	 * Best    -> O(n*k) <br>
	 * Average -> O(n*k) <br>
	 * Worst   -> O(n*k) <br>
	 * <br>
	 * Where k is the number of bits required to store each key.
	 *
	 * @SpaceComplexity
	 * O(n+k)
	 *
	 * @Stable
	 * Yes
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param array Elements to be ordered.
     * @param order Order preference.
     *
     * @return      Sorted array.
	 */
	@Override
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order)
			throws BadArgumentTypeException,
				   BadRadixArgumentException {
		if (elements.length == 0 || elements == null) {
			return elements;
		}

		// Invalid inputs
		if        (elements[0] instanceof Float) {
			throw new BadArgumentTypeException("This implementation of Radix Sort is not ready to sort a floating point array!");
		} else if (elements[0] instanceof Character) {
			CountSort<Character> cs = new CountSort<>();
			return cs.sort(elements, order);
		} else if (elements[0] instanceof String) {
			throw new BadArgumentTypeException("This implementation of Radix Sort cannot order String arrays!");
		}

		CountSort<T> cs = new CountSort<T>();
		int maxElem = max(elements);

		// Only on the last digit iteration elements are ordered in their
		// rightful order
		Order pseudoOrder = Order.ASC;
		int exponent = 1;
		while ((maxElem / exponent) > 0) {
			// In the last exponent iteration, the requested order is used so 
			// that Count Sort orders the array as it should
			if (order == Order.DESC && (maxElem / (exponent * 10)) <= 0) {
				pseudoOrder = order;
			}
			elements = cs.sort(elements, pseudoOrder, true, exponent);
			exponent *= 10;
		}

		return elements;
	}
	
	/**
	 * Find the maximum element of a generic array.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements Elements to be ordered.
	 *
	 * @return Maximum element.
	 *
	 * @throws BadArgumentTypeException 
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable<T>> int max(T[] elements) 
			throws BadArgumentTypeException {
		T maxElement = elements[0];

		for (T e : elements) {
			if (e.compareTo(maxElement) > 0) maxElement = e;
			if ((int) e < 0) throw new BadArgumentTypeException("This Radix Sort implementation is not ready to sort negative numbers!");
		}
		return (int) maxElement;
	}

}
