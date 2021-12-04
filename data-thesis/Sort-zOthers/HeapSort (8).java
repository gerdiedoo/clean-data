package src.algorithms;

import src.strategy.Order;

/**
*
* Sorting algorithm that uses a Binary Heap implemented on a list to order
* elements. The smallest or largest element is found and placed at the top of 
* the heap. That process is repeated until no elements are left.
*
* 1) Build a min/max heap. <br>
* 2) Smallest/largest item is stored at the root of the heap.
* 	 Replace the root element with the last element of the heap followed by 
*    reducing the size of the heap by 1. <br>
* 3) Repeat 2 until the heap has size 1.
*
* DISCLAIMER: <br>
* 	 A heap is represented using an array. To do so, the two children of a
*    node use a mathematical function to find their position in the array:
*    LEFT CHILD =  2 * parent_position + 1
*    RIGHT CHILD = 2 * parent_position + 2
*
* @author: <a href="mailto:p.aceredag@gmail.com">Pablo Acereda</a>
* @version: 1.0
* @license: Copyright 2021 © Pablo Acereda
* License under Apache License, Version 2.0
*
* @param <T> Primitive datatype or object.
*
*/
public class HeapSort<T> extends SortingAlgorithm<T> {
	/**
	 * Sorts an array of elements using Heap Sort algorithm.
	 *
	 * @TimeComplexity
	 * Best    -> O(n) <br>
     * Average -> O(log(n)) <br>
     * Worst   -> O(log(n)) <br>
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
     *
	 */
	@SuppressWarnings("hiding")
	public <T extends Comparable<T>> T[] sort(T[] elements, Order order) {
		int numElements = elements.length;

		// Build a max/min heap.
		// Heapify analyzes the children of a node. In a binary heap represented
		// using an array, that means the elements a position 2x+1 and 2x+2 (x 
		// being the parent node).
		for (int i = numElements / 2 - 1; i >= 0; i--) {
			heapify(elements, numElements, i, order);
		}

		// Create the output array by extracting the values, in order, from the
		// heap, doing it one by one.
		for (int i = numElements  - 1; i > 0; i--) {
			this.swap(elements, i, 0);
			heapify(elements, i, 0, order);
		}
		
		return elements;
	}

	/**
	 * Recursive function of converting a binary tree into a complete binary
	 * tree. To preserve heap-order property the value of each node must be
	 * greater or equal to its children.
	 * 
	 * DISCLAIMER: <br>
	 *    A heap must be a complete tree.
	 * 
	 * @param <T> Primitive datatype or object.
	 * 
	 * @param elements Elements to order.
	 * @param n Length of array to evaluate.
	 * @param i Initial position (considered as parent/root).
	 * @param order Order preference.
	 * 
	 * @return Sorted array.
	 */
	@SuppressWarnings("hiding")
	private <T extends Comparable <T>> void heapify(T[] elements, int n, int i, Order order) {
		int largest = i;
		int left  = 2 * i + 1; // Left children
		int right = 2 * i + 2; // Right children
		
		// Check if children exists and are larger/smaller than the root.
		if (left < n &&
			((order == Order.ASC  && elements[largest].compareTo(elements[left]) < 0) ||
			 (order == Order.DESC && elements[largest].compareTo(elements[left]) > 0))) {
			largest = left;
		}
		
		if (right < n &&
			((order == Order.ASC  && elements[largest].compareTo(elements[right]) < 0) ||
			 (order == Order.DESC && elements[largest].compareTo(elements[right]) > 0))) {
			largest = right;
		}

		// Change root
		if (largest != i) {
			this.swap(elements, i, largest);
			// Recursively heapify the affected sub-tree.
			heapify(elements, n, largest, order);
		}
	}
}
