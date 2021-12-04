package main;

/**
 * Created by abdullahodibat.
 */
public class QuickSort {
    public static void main(String args[]) {

        int[] arr = {8, 4, 5, 1, 2, 3, 6, 9, 8};

        quickSort(arr);
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static int[] quickSort(int[] arr) {
        int length = arr.length;
        if (length == 0 || length == 1) return arr;
        else {
            sort(arr, 0, length - 1);
            return arr;
        }
    }

    public static void sort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low + (high - low) / 2];
        while (i <= j) {
            while (arr[j] > pivot) {
                j--;
            }
            while (arr[i] < pivot) {
                i++;
            }
            if (i <= j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
                j--;
            }
        }
        if (i < high) {
            sort(arr, i, high);
        }
        if (j > low) {
            sort(arr, low, j);
        }
    }

}
