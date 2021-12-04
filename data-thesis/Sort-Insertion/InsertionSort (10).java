package sort.primary;

import sort.Sort;

/**
 * Insertion sort needs (N^2)/4 comparisons and exchanges on average.
 * Time complexity : O(N^2)
 * Space complexity: O(1)
 */
public class InsertionSort extends Sort {

    @Override
    public void sortMethod(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
            }
        }
    }

    public static void sort(Comparable[] a) {
        new InsertionSort().sortMethod(a);
    }
}
