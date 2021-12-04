package Sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sethu on 10/5/17.
 */


public class QuickSort {

    private static int elements_array[];

    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            elements.add(sc.nextInt());
        }
        sc.close();

        elements_array = new int[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            elements_array[i] = elements.get(i);
        }

       doQuickSort( elements.size() - 1,0);

        for (int anElement : elements_array) {
            System.out.println(anElement);
        }

    }

    private static void doQuickSort(int high, int low) {
        // Calculating the middle element
        int pivot = elements_array[low + ((high - low) / 2)];
        int i = low;
        int j = high;

        // There will be two tracking of the array.
        while (i <= j) {
            // If the i element is less than the pivot, then the i track iterates over the next element
            // in the array from its position
            while (elements_array[i] < pivot) {
                i++;
            }

            // If the j element is greater than the pivot, then the j track iterates over the previous element
            // in the array from its position
            while (elements_array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                doSwap(i, j);
                i++;
                j--;
            }

        }

        if(low < j){
            doQuickSort(low,j);
        }
        if(i< high){
            doQuickSort(i,high);
        }
    }


    private static void doSwap(int i, int j) {
        int temp = elements_array[i];
        elements_array[i] = elements_array[j];
        elements_array[j] = temp;
    }
}
