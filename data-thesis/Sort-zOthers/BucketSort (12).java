package com.intrafoundation;

import java.util.Collections;
import java.util.Arrays;

public class BucketSort extends BaseSort {
    public void sort(int[] arr) {
        swaps = 0;
        System.out.println(Arrays.toString(arr));

        final int len = arr.length;

        int maxV = 0;
        for (int index = 0; index < len; index++) {
            final int a = arr[index];
            if (a > maxV) maxV = a;
        }

        int[] bucket = new int[maxV + 1];
        System.out.println(Arrays.toString(bucket));
        for (final int a : arr) {
            System.out.println("a=" + a);
            bucket[a] = a;
        }

        final int bucketLen = bucket.length - 1;
        for (int index = 0, arrIndex = 0; index < bucketLen; index++) {
            final int a = bucket[index];
            if (a != 0) {
                arr[arrIndex++] = a;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}

