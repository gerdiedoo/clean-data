
class combSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = combSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] combSort(int [] arr, int sizeofArr){
		int temp, gapValue=sizeofArr-2;
		for (int i=gapValue;i>0;i--){
			for (int k=0;k<sizeofArr-i;k++)
				if (arr[k] > arr[k+i]){
					temp = arr[k];
					arr[k] = arr[k+i];
					arr[k+i] = temp;
				}
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
