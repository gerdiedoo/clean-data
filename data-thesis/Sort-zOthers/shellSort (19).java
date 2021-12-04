
class shellSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = shellSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] shellSort(int [] arr, int sizeofArr){
		int temp, gapValue = (int) sizeofArr/2;
		while (gap > 0){
			for (int k=0;k<sizeofArr-gapValue;k++)
				if (arr[k] > arr[k+gap]){
					temp = arr[k+gap];
					arr[k+gap] = arr[k];
					arr[k] = temp;
				}
			gap = (int) gap/2;
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
