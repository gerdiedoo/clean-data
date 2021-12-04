package ec; 

import java.util.ArrayList;

public class CockTailSort<T extends Comparable<T>> implements SortingAlgorithms {
	private ArrayList<T> list = new ArrayList<T>();
	private static  long comparisons = 0;
	private static  long swaps = 0;
	private static  long runtime = 0;
	static long start;
	static long end;
	public CockTailSort() {
		sortingAlgorithms();
	}
	public ArrayList<T> cockTailSort(ArrayList<T> tail) {
		boolean sort;
		long comparisons = 0;
		long swaps = 0;
		start = System.currentTimeMillis();
		do {
			sort = false;
			for(int i = 0 ; i <= tail.size() - 2 ; i++) {
				comparisons++;
				if(tail.get(i).compareTo(tail.get(i + 1)) > 0) {
					T swap = tail.get(i);
					tail.set(i, tail.get(i + 1));
					tail.set(i + 1, (T) swap);
					sort = true;
					swaps++;
				}
			}
			if(!sort) {
				break;
			}
			sort = false;
			for(int j = tail.size() - 2 ; j >= 0 ; j--) {
				if(tail.get(j).compareTo(tail.get(j + 1)) > 0) {
					T swaped = tail.get(j);
					tail.set(j, tail.get(j + 1));
					tail.set(j + 1, (T) swaped);
					sort = true;
					swaps++;
				}
			} 
		}while(sort);
		end = System.currentTimeMillis();
		CockTailSort.comparisons = comparisons;
		CockTailSort.swaps = swaps;
		long runtimes = end - start;
		CockTailSort.runtime = runtimes;
		return tail;
	}

	@Override
	public void sortingAlgorithms() {
		cockTailSort(list);
		
	}	
	public ArrayList<T> print(ArrayList<T> bubble) {
		ArrayList<T> bs = new ArrayList<T>();
		for(int i = 0 ; i < bubble.size() ; i++) {
			bs.add(bubble.get(i));
		}
		return bs;
	}
	public static void compare() {
		System.out.print("Comparisons: " + comparisons + "\t");
		
	}
	public static void swap() {
		System.out.print("Swaps: " + swaps);
	}
	public static void runtime() {
		System.out.print("Runtime: "  + runtime + " ms");
	}
}
