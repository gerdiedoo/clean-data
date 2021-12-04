package sortlab.algorithm;

import java.util.Comparator;

public final class FatefulSort<T> implements SortAlgorithmInterface<T> {
  private final Comparator<T> comparator;

  public FatefulSort(Comparator<T> comparator) {
    //This is NOT a valid sorting algorithm. It was inspired by
    //https://xkcd.com/1185/ and will only work on data sets that (is if by fate)
    //are already sorted. Because it relies so much on fate it does not include
    //any error checking (if you can't trust fate then what good is error
    //checking)

    this.comparator = comparator;
  }

  public T[] sort(T[] input) {
    //Behold the fastest sort (for already sorted sets)
    return input;
  }
}
