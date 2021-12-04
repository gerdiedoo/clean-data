package sort.merge;

import sort.Sort;

/**
 * Top-down merge sort.
 * Time complexity : O(NlogN)
 * Space complexity: O(N)
 */
public class MergeSort extends Sort {

    private static Comparable[] aux; // auxiliary array

    @Override
    public void sortMethod(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Merge sort.
     *
     * @param a array to be sorted.
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        new MergeSort().sortMethod(a);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // sorting left-hand side.
        sort(a, mid + 1, hi); // sorting right-hand side.
        merge(a, lo, mid, hi); // merging result.
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // merge a[lo..mid] and a[mid+1..hi]
        int i = lo, j = mid + 1;

        // copy a[lo...hi] to aux[lo...hi].
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        // merge all elements back into a.
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; // left-hand side is empty.
            else if (j > hi) a[k] = aux[i++]; // right-hand side is empty.
            else if (less(aux[j], aux[i])) a[k] = aux[j++]; // The right-hand side is lower than the left-hand side.
            else a[k] = aux[i++]; // The right-hand side is greater than or equal to the left-hand side.
        }
    }
}
