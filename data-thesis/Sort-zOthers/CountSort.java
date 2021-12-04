package src.algorithms;

import java.util.Arrays;

import src.exceptions.BadArgumentTypeException;
import src.exceptions.BadRadixArgumentException;
import src.strategy.Order;

/**
 *
 * Sorting algorithm that is based on keys between a specific range. It counts  
 * the number of occurrences of each element of the array (hashing-like).
 * Afterwards, the position of each object is calculated adding the occurrences
 * at each position.
 *
 * 1) Store the number of occurrences of each object.
 * 2) Modify the count array so that each element stores the sum of the previous
 *    counts.
 * 3) Output each object from the input sequence and decrease its count by 1.
 *
 * @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
 * @version: 1.0
 * @license: Copyright 2021 © Pablo Acereda
 * License under Apache License, Version 2.0
 *
 * @param <T> Primitive datatype or object.
 *
 */
public class CountSort<T extends Comparable<T>> extends SortingAlgorithm<T> {
	/**
	 * Sorts an array of elements using Count Sort algorithm.
     *
     * @TimeComplexity  
     * Best    -> O(n+k) <br>
     * Average -> O(n+k) <br>
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
     *
	 * @throws BadArgumentTypeException
	 * @throws BadRadixArgumentException 
	 */
	@Override
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order) 
			throws BadRadixArgumentException,
				   BadArgumentTypeException {
		return this.sort(elements, order, false, 0);
	}

	/**
	 * Sorts an array of elements using Count Sort algorithm. Can be used as
	 * subroutine for RadixSort.
	 *
	 * @TimeComplexity
     * Best    -> O(n+k) <br>
     * Average -> O(n+k) <br>
     * Worst   -> O(n²) <br>
     *
     * @SpaceComplexity
     * O(n+k)
     *
     * @Stable
     * Yes
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements Elements to be ordered.
     * @param order Order preference.
	 * @param isRadix This algorithm can be a subroutine for RadixSort.
	 * @param exponent Only when isRadix=true. Radix/base being evaluated.
	 *
	 * @return Sorted array.
	 *
	 * @throws BadRadixArgumentException 
	 * @throws BadArgumentTypeException
	 */
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order, boolean isRadix, int exponent) 
			throws BadRadixArgumentException, 
		       	   BadArgumentTypeException {

		// Make sure arguments are right
		if (isRadix && exponent == 0) {
			throw new BadRadixArgumentException("Using CountSort as part of RadixSort. Need a radix/base to proceed!");
		} else if (!isRadix && exponent != 0) {
			throw new BadRadixArgumentException("No exponent is needed, provide exponent=0 or use function without isRadix and exponent arguments!");
		}

		// No elements to order
		if (elements.length == 0 || elements == null) {
			return elements;
		}

		// Invalid inputs
		if        (!isRadix && elements[0] instanceof Float) {
			throw new BadArgumentTypeException("This implementation is not ready to sort a floating point array!");
		} else if (!isRadix && elements[0] instanceof String) {
			throw new BadArgumentTypeException("Count Sort cannot order String arrays, try with a Character array!");
		}

		int numElements = elements.length;
		int numBuckets  = (elements[0] instanceof Integer) ? 10 : 256;

		// Sorted array
		T[] output = Arrays.copyOf(elements, numElements);
		// Store the count of each type element appearance
		int[] count = new int[numBuckets];

		// Count elements appearances.
		for (T elem : elements) {
			int digit = (elem instanceof Character) ? Character.getNumericValue((char) elem) : (int) elem;
			// When using this code as subroutine for RADIX it means that each 
			// element has multiple digits.
			int bucket = isRadix ? (digit / exponent) % numBuckets : digit;
			count[bucket]++;
		}

		// Store the sum of the previous counts, symbolizing the index of the
		// output array.
		for (int i=1; i<numBuckets; i++) {
			count[i] += count[i-1];
		}

		// Build output array.
		for (int i=0; i<numElements; i++) {
			int bucket = 0;
			int j = i;

			if (isRadix) {
				j = numElements - 1 - i;
				int digit = this.numericValue(elements[j]);
				bucket = (digit / exponent) % numBuckets;
			} else {
				int digit = this.numericValue(elements[j]);
				bucket = digit;
			}
			// Move element to output array
			output[count[bucket] - 1] = elements[j];
			count[bucket]--;
		}

		// Copy array in selected order
		for (int i=0; i<numElements; i++) {
			if (order == Order.ASC) // ASCENDING
				elements[i] = output[i];
			else					// DESCENDING
				elements[i] = output[numElements - 1 - i];
		}

		return elements;
	}

	/**
	 * Transform a character to a number value.
	 *
	 * @param <T> Primitive datatype or object.
	 *
	 * @param elements Character to transform.
	 *
	 * @return Integer transformed value.
	 */
	@SuppressWarnings("hiding")
	private <T> int numericValue(T elements) {
		if (elements instanceof Character)
			return Character.getNumericValue((char) elements);
		else
			return (int) elements;
	}

}
