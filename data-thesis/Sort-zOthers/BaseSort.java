package com.intrafoundation;

import java.util.Arrays;

/**
 * For BaseSort we actually implement everything using defaults, so we can use them as a
 * fallback and testing purposes. The extended class override with alg specific functionality.
 */
public class BaseSort {
    protected int swaps = 0;

    public void sort(int[] arr) {
        swaps = 0;
        Arrays.sort(arr);
    }

    public int getSwaps() {
        return swaps;
    }

    protected void swap(int[] arr, int indexA, int indexB) {
        final int swapTemp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = swapTemp;
        swaps++;
    }

/*    public static void main(String[] args) {
        BaseSort s = new BaseSort();
        int[] arr = new int[]{2, 3, 1};
        s.sort(arr);
        System.out.println("BaseSort = " + Arrays.equals(new int[]{1, 2, 3}, arr));
    }*/
}
