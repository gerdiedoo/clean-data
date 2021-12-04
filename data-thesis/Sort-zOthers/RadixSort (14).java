package ec;

import java.util.ArrayList;

public class RadixSort<T extends Comparable<T>> implements SortingAlgorithms{
	ArrayList<Integer> list = new ArrayList<Integer>();
	private static  long comparisons = 0;
	private static  long swaps = 0;
	private static  long runtime = 0;
	static long start;
	static long end;
	public RadixSort() {
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> radixSort(ArrayList<Integer> list4) {
		long comparisons = 0;
		long swaps = 0;
		start = System.currentTimeMillis();
		ArrayList<Integer>[] bucks = new ArrayList[list4.size()];
		Integer i = new Integer(0);
		for(int j = 0 ; j < list4.size() ; j++) {
			if(i < list4.get(j)) {
				i = list4.get(j);
			}
		}
		for(int l = 0 ; l < bucks.length ; l++) {
			ArrayList<Integer> bucketList = new ArrayList<>();
			bucks[l] = bucketList;
		}
		int y = i.toString().length();
		for(int q = 1 ; q <= y ; q++) {
			for(int a = 0 ; a <= list4.size() - 1 ; a++) {
				bucks[(int) ((list4.get(a) / Math.pow(10, q - 1)) % 10)].add(list4.get(a));
			}
			int k = 0;
			for(int z = 0 ;  z <= bucks.length - 1 ; z++) {
				for(int x = 0 ; x < bucks[z].size() ; x++) {
					int c = (int) bucks[z].get(x);
					list4.set(k++, (int) c);
				}
				bucks[z].clear();
			}
		}
		end = System.currentTimeMillis();
		RadixSort.comparisons = comparisons;
		RadixSort.swaps = swaps;
		long runtimes = end - start;
		RadixSort.runtime = runtimes;
		return list4;
	}
	public ArrayList<Integer> print(ArrayList<Integer> bubble) {
		ArrayList<Integer> bs = new ArrayList<Integer>();
		for(int i = 0 ; i < bubble.size() ; i++) {
			bs.add(bubble.get(i));
		}
		return bs;
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
	@Override
	public void sortingAlgorithms() {
		
		radixSort(list);
	}
	
}
