package ec;
import java.util.ArrayList;
public class CountingSort<T extends Comparable<T>> implements SortingAlgorithms{
	ArrayList<T> list = new ArrayList<T>();
	int[] cast = new int[10];
	static long comparisons = 0;
	static long swaps = 0;
	static long runtime;
	static long start;
	static long endTime;
	public CountingSort() {
		sortingAlgorithms();
	}
	public int[] countingSort(int[] list) {
		int j = 0;
		for (int i = 0; i < list.length; i++) {
			if (j < list[i]) {
				j = list[i];
			}
		}
		return countingSort2(list, j);
	}
	public int[] countingSort2(int[] list, int k) {
		int[] result = new int[list.length];
		int[] counts = new int[k + 1];
		for (int i = 0; i <= k; i++) {
			counts[i] = 0;
		}
		for (int i = 0; i <= list.length - 1; i++) {
			counts[list[i]] = counts[list[i]] + 1;
		}
		for (int i = 1; i <= k; i++) {
			counts[i] += counts[i - 1];
		}
		for (int i = list.length - 1; i >= 0; i--) {
			result[counts[list[i]] - 1] = list[i];
			counts[list[i]] = counts[list[i]] - 1;
		}
		return result;
	}
	public static void compare() {
		System.out.print("Comparisons: " + comparisons + "\t\t");

	}
	public static void swap() {
		System.out.print("Swaps: " + swaps);
	}
	public static void runtime() {
		System.out.print("Runtime: "  + runtime + " ms");
	}
	public int[] count(int[] list) {
		int[] tempArray = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			tempArray[i] = list[i];
		}
		return tempArray;
	}
	public ArrayList<T> print(ArrayList<T> bubble) {
		ArrayList<T> bs = new ArrayList<T>();
		for(int i = 0 ; i < bubble.size() ; i++) {
			bs.add(bubble.get(i));
		}
		return bs;
	}
	public int[] copyArray(int[] listToCopyIn) {
		int[] tempArray = new int[listToCopyIn.length];
		for (int i = 0; i < listToCopyIn.length; i++) {
			tempArray[i] = listToCopyIn[i];
		}
		return tempArray;
	}
	@Override
	public void sortingAlgorithms() {
		start = System.currentTimeMillis();
		countingSort(cast);
		endTime = System.currentTimeMillis();
		runtime = endTime - start;
	}
} 
