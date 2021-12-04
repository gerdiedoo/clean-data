
class countingSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = countingSort(arr, sizeofArr);
	}

	static int [] countingSort(int [] arr, int n){
		int max = 0;
		for (int i=0;i<n;i++) if (max > arr[i]) max = arr[i];
		int [] tempArr = new int [max];
		for (int i=0;i<n;i++) tempArr[arr[i]]++;
		for (int i=0;i<max-1;i++) tempArr[i+1] = tempArr[i] + tempArr[i+1];
		int [] lastArr = new int [n];
		for (int i=n-1;i>=0;i--) { lastArr[tempArr[arr[i]]-1] tempArr[arr[i]]--; }
		return lastArr;
	}
}
