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
 * @description MergeSort - algorithm implementation
 * @package ie.peternagy.algorithms.sorting
 */
package ie.peternagy.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    /**
     * Merge sort comparable items in ascending order
     * 
     * Time complexity: O(n log n)
     * 
     * @param items - the array holding Comparable items
     */
    public static void sort(Comparable[] items) {
        sort(items, true);
    }

    /**
     * Merge sort comparable items in specified order
     * 
     * Time complexity: O(n log n)
     * 
     * @param items - the array holding Comparable items
     * @param isAsc - the order of sorting
     */
    public static void sort(Comparable[] items, boolean isAsc) {
        int arrayLength = items.length;
        mergeSort(items, 0, arrayLength - 1, isAsc);
    }

    /**
     * Recursive method to divide and merge array elements  
     * 
     * @param items - the array holding Comparable items
     * @param lowIndex - the lower index to start merging from
     * @param highIndex - the upper index to merge 
     * @param isAsc - the order of sorting
     */
    private static void mergeSort(Comparable[] items, int lowIndex, int highIndex, boolean isAsc) {
        if (lowIndex < highIndex) {
            int middle = lowIndex + (highIndex - lowIndex) / 2;
            mergeSort(items, lowIndex, middle, isAsc);
            mergeSort(items, middle + 1, highIndex, isAsc);
            merge(items, lowIndex, middle, highIndex, isAsc);
        }
    }

    /**
     * Merge the items
     * 
     * @param items - the array holding Comparable items
     * @param lowIndex - the lower index to start merging from
     * @param middle - the middle of the current chunk to merge
     * @param highIndex - the upper index to merge
     * @param isAsc  - the order of sorting
     */
    private static void merge(Comparable[] items, int lowIndex, int middle, int highIndex, boolean isAsc) {
        //Create the sub array
        Comparable[] helper = new Comparable[items.length];
        System.arraycopy(items, lowIndex, helper, lowIndex, (highIndex - lowIndex) + 1);
        
        int i = lowIndex;
        int j = middle + 1;
        int k = lowIndex;
        //Sort
        while (i <= middle && j <= highIndex) {
            if (isAsc && helper[i].compareTo(helper[j]) < 0 ||
                    !isAsc && helper[i].compareTo(helper[j]) > 0) {
                items[k] = helper[i];
                i++;
            } else {
                items[k] = helper[j];
                j++;
            }
            k++;
        }
        
        //Copy the rest of the sub array as is
        System.arraycopy(helper, i, items, k, (middle - i) + 1);
    }
}
