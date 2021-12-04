package com.intrafoundation;

import java.util.Arrays;

public class InsertionSort extends BaseSort {
    public void sort(int[] arr) {
        swaps = 0;
        final int begin = 1;
        final int end = arr.length;
        for (int index = begin; index < end; index++) {
            int key = arr[index]; //aka b
            int repositionIndex = index - 1;
            while ((repositionIndex >= 0) && (arr[repositionIndex] > key)) {
                // since we have key aka b stored, we don't need to do a/b swaps
                // but can do straight compare and overwrites
                arr[repositionIndex + 1] = arr[repositionIndex];
                repositionIndex--;
                swaps++;
            }
            arr[repositionIndex + 1] = key; //insert key at beginning of set being moved up
        }
    }

}


