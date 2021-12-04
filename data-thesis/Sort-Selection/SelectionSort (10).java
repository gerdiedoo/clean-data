package sort.primary;

import sort.Sort;

/**
 * Selection sort needs (N^2)/2 comparisons, and N exchanges.
 * Time complexity : O(n^2)
 * Space complexity: O(1)
 */
public class SelectionSort extends Sort {

    @Override
    public void sortMethod(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void sort(Comparable[] a) {
        SelectionSort sort = new SelectionSort();
        sort.sortMethod(a);
    }
}
