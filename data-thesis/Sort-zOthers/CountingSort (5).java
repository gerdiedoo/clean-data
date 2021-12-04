package sortAlgorithms;

import helperUtils.Utility;

public class CountingSort {

  public static void main(String[] args) {
    int[] inputArr = { 56, 42, 50, 47, 44, 51, 49, 45, 42, 53, 55, 54, 43 };
    Utility.printArray(inputArr, true, "Insertion Sort");
    countingSort(inputArr, 42, 56);
    Utility.printArray(inputArr, false, null);
  }

  public static void countingSort(int[] arr, int min, int max) {
    int[] countsArr = new int[(max - min) + 1];

    for (int i = 0; i < arr.length; i++) {
      countsArr[arr[i] - min]++;
    }

    int j = 0;
    for (int i = min; i <= max; i++) {
      while (countsArr[i - min] > 0) {
        arr[j++] = i;
        countsArr[i - min]--;
      }
    }
  }

}