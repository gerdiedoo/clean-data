package ec;
import java.util.ArrayList;
public class GnomeSort<T extends Comparable<T>> implements SortingAlgorithms{
	ArrayList<T> list = new ArrayList<T>();
	private static  long comparisons = 0;
	private static  long swaps = 0;
	private static  long runtime = 0;
	static long start;
	static long end;
	public GnomeSort() {
		sortingAlgorithms();
	}
	@SuppressWarnings("unused")
	public ArrayList<T> gnomeSort(ArrayList<T> list2) {
		int in = 1;
		T sw;
		long comparisons = 0;
		long swaps = 0;
		start = System.currentTimeMillis();
		for (int gnome = 1; gnome < list2.size();) {
			comparisons++;
			if (list2.get(gnome - 1).compareTo(list2.get(gnome)) <= 0) {
				gnome++;
			} else {
				swaps++;
				T swap = list2.get(gnome);
				list2.set(gnome, list2.get(gnome - 1));
				list2.set(gnome - 1, swap);
				gnome--;
				if (gnome == 0) {
					gnome = 1;
				}
			}
		}
		end = System.currentTimeMillis();
		GnomeSort.comparisons = comparisons;
		GnomeSort.swaps = swaps;
		long runtimes = end - start;
		GnomeSort.runtime = runtimes;
		return list2;
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
	@Override
	public void sortingAlgorithms() {
		gnomeSort(list);
	}
} 
