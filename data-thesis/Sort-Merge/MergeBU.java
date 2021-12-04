package sort.merge;

import sort.Sort;

/**
 * Description: Down-top merge sort.
 * Time complexity : O(NlogN)
 * Space complexity: O(N)
 * Created By xxm
 */
public class MergeBU extends Sort {

    private static Comparable[] aux; // auxiliary array

    /**
     * Down-top merge sort.
     * |        a[i]
     * sz=1            | 4 7 5 3 6 1 0 2 9 8
     * merge(a,0,0,1)  | 4 7
     * merge(a,2,2,3)  |     3 5
     * merge(a,4,4,5)  |         1 6
     * merge(a,6,6,7)  |             0 2
     * merge(a,8,8,9)  |                 8 9
     * sz=2            |
     * merge(a,0,1,3)  | 3 4 5 7
     * merge(a,4,5,7)  |         0 1 2 6
     * merge(a,8,9,9)  |                 8 9
     * sz=4            |
     * merge(a,0,3,7)  | 0 1 2 3 4 5 6 7
     * sz=8            |
     * merge(a,0,7,9)  | 0 1 2 3 4 5 6 7 8 9
     *
     * @param a array of list need to sort.
     */
    public void sortMethod(Comparable[] a) {
        for (int sz = 1; sz < a.length; sz = sz + sz) // size of array `sz`.
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) // `lo`: the index of subarray.
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        new MergeBU().sortMethod(a);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // merge a[lo..mid] and a[mid+1..hi]
        int i = lo, j = mid + 1;

        // copy array `a` to `aux`
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
