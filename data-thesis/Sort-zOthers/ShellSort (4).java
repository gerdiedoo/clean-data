package sortAlgorithms;

import helperUtils.Utility;

public class ShellSort {

  public static void main(String[] args) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Shell Sort");
    for (int gap = inputArr.length / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < inputArr.length; i += gap) {
        int pickedElement = inputArr[i];
        int j = i;
        while (j > 0 && inputArr[j - gap] > pickedElement) {
          inputArr[j] = inputArr[j - gap];
          j -= gap;
        }
        inputArr[j] = pickedElement;
      }
    }
    Utility.printArray(inputArr, false, null);
  }
}