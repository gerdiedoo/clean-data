package sort.quick;

import sort.Sort;

public class Quick3Way extends Sort {

    public void sortMethod(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];

        // a[i .. gt] is the interval to be sorted.
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            // a[i] < v, a[lt] <-> a[i]
            if (cmp < 0) exch(a, lt++, i++);
            // a[i] > v, a[gt] <-> a[i]
            else if (cmp > 0) exch(a, i, gt--);
            // a[i] == v, expand [lt, i-1]
            else i++;
        }
        // for now: a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

}
