import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Counting Sort Algorithm");

        System.out.println("Enter total number of elements:");
        int lengthOfTheArray = input.nextInt();

        int[] arrayOfIntegersToSort = new int[lengthOfTheArray];

        System.out.printf("Enter %d integers:%n", lengthOfTheArray);
        for (int i = 0; i < lengthOfTheArray; i++) {
            arrayOfIntegersToSort[i] = input.nextInt();
        }

        int[] sortedArray = countingSort(arrayOfIntegersToSort);

        System.out.printf("Sorted array using Counting Sort Algorithm: %s%n",
                Arrays.toString(sortedArray));

        input.close();
    }

    private static int[] countingSort(int[] arrayToSort) {
        int[] counterBuckets = new int[arrayToSort.length + 1];

        for (int i : arrayToSort) {
            ++counterBuckets[i];
        }

        int counter = 0;
        for (int i = 0; i < counterBuckets.length; i++) {
            for (int j = 0; j < counterBuckets[i]; j++) {
                arrayToSort[counter] = counterBuckets[i];
                ++counter;
            }
        }
        return arrayToSort;
    }
}
