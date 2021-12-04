/**
 * Copyright (C) 2016 Peter Nagy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * ======================================================================
 *
 * @author Peter Nagy - https://peternagy.ie
 * @since December 2016
 * @version 0.1
 * @description HeapSort - Heap sort implementation
 * @package ie.peternagy.algorithms.sorting
 */
package ie.peternagy.algorithms.sorting;

public class HeapSort {

    private static int arrayLength;

    /**
     * Bubble sort Comparable array elements
     *
     * Time complexity: O(n^2)
     *
     * @param items - the objects to sort
     */
    public static void sort(Comparable[] items) {
        sort(items, true);
    }

    /**
     * Bubble sort Comparable array elements with order
     *
     * Time complexity: O(n^2)
     *
     * @param items - the objects to sort
     * @param isAsc - if true the order will be increasing (ascending)
     */
    public static void sort(Comparable[] items, boolean isAsc) {
        arrayLength = items.length - 1;
        for (int i = arrayLength / 2; i >= 0; i--) {
            heapify(items, i, isAsc);
        }

        for (int i = arrayLength; i > 0; i--) {
            swapItems(items, 0, i);
            arrayLength--;
            heapify(items, 0, isAsc);
        }
    }

    /**
     * Shift objects until heap property is fulfilled
     *
     * @param items - the objects to heapify
     * @param rootIndex - start recursion from
     * @param isAsc - order of the items
     */
    private static void heapify(Comparable[] items, int rootIndex, boolean isAsc) {
        int leftIndex = rootIndex * 2;
        int rigthIndex = leftIndex + 1;
        int greaterIndex = rootIndex;

        if (leftIndex <= arrayLength
                && (isAsc && items[leftIndex].compareTo(items[greaterIndex]) > 0
                || !isAsc && items[leftIndex].compareTo(items[greaterIndex]) < 0)) {
            greaterIndex = leftIndex;
        }

        if (rigthIndex <= arrayLength
                && (isAsc && items[rigthIndex].compareTo(items[greaterIndex]) > 0
                || !isAsc && items[rigthIndex].compareTo(items[greaterIndex]) < 0)) {
            greaterIndex = rigthIndex;
        }

        if (greaterIndex != rootIndex) {
            swapItems(items, rootIndex, greaterIndex);
            heapify(items, greaterIndex, isAsc);
        }
    }

    /**
     * Swap items in array
     *
     * @param items - the array to work with
     * @param indexOne - the first item index to swap
     * @param indexTwo - second index to swap with first
     */
    protected static void swapItems(Comparable[] items, int indexOne, int indexTwo) {
        Comparable tmp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = tmp;
    }
}
