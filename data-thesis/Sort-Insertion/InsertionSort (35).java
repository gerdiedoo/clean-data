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
 * @description InsertionSort - Insertion sort implementation
 * @package ie.peternagy.algorithms.sorting
 */
package ie.peternagy.algorithms.sorting;

public class InsertionSort {

    public static void sort(Comparable[] items) {
        sort(items, true);
    }

    public static void sort(Comparable[] items, boolean isAsc) {
        Comparable key;
        int lowIndex;
        for (int i = 1; i < items.length; i++) {
            key = items[i];
            lowIndex = i;
            
            while(--lowIndex >= 0){
                if((isAsc && items[lowIndex].compareTo(key) > 0)
                        || (!isAsc && items[lowIndex].compareTo(key) < 0))
                    items[lowIndex + 1] = items[lowIndex];
                else
                    break;
            }
            
            items[lowIndex + 1] = key;
        }
    }
}
