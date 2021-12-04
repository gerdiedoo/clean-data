import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Radix Sort Algorithm");

        System.out.print("Enter total number of elements: ");
        int lengthOfTheArray = input.nextInt();

        int[] arrayOfIntegersToSort = new int[lengthOfTheArray];

        System.out.printf("Enter %d integers:%n", lengthOfTheArray);
        for (int i = 0; i < lengthOfTheArray; i++) {
            arrayOfIntegersToSort[i] = input.nextInt();
        }

        int[] sortedArray = radixSort(arrayOfIntegersToSort);

        System.out.printf("Sorted array using Radix Sort Algorithm: %s%n",
                Arrays.toString(sortedArray));

        input.close();
    }

    private  static int[] radixSort(int[] arrayToSort) {
        int maximumNumber = getMax(arrayToSort);
        for (int exp = 1; maximumNumber / exp > 0; exp *= 10) {
            countSort(arrayToSort, exp);
        }
        return arrayToSort;
    }

    private static int getMax(int[] array) {
        int maximumValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximumValue) {
                maximumValue = array[i];
            }
        }
        return maximumValue;
    }

    private static void countSort(int[] arrayToSort, int exp) {
        int[] outputArray = new int[arrayToSort.length];
        int[] countingArray = new int[10];
        Arrays.fill(countingArray, 0);

        for (int i = 0; i < arrayToSort.length; i++) {
            countingArray[(arrayToSort[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            countingArray[i] += countingArray[i - 1];
        }

        for (int i = arrayToSort.length - 1; i >= 0; i--) {
            outputArray[countingArray[(arrayToSort[i] / exp) % 10] - 1] = arrayToSort[i];
            countingArray[(arrayToSort[i] / exp) % 10]--;
        }

        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = outputArray[i];
        }
    }
}