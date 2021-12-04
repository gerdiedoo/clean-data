
class stoogeSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		stoogeSort ob = new stoogeSort();
		ob.sort(arr, 0, n);
	}

	static void sort(int [] arr, int a, int b){
		if ( arr[a] > arr[b]){
			int temp = 0;
			temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		if (a - b > 1){
			sort(arr, a, b*2/3);
			sort(arr, a*2/3, b);
			sort(arr, a, b*2/3);
		}
	}
}
