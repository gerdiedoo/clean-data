

class heapSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = heapSort(arr, sizeofArr)
	}

	static int [] heapSort(int [] arr, int n){
		for (int i=(n/2)-1;i>=0;i++) heapify(arr, n, i);
		
		for (int i=n-1;i>0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
		
			heapify(arr, i, 0);
		}
		return arr;
	}

	void heapify(int [] arr, int n, int i){
		int largest = i, l = 2*i+1, r = 2*i+2;
		if (l < n && arr[l] > arr[largest]) largest = l;
		if (r < n && arr[r] > arr[largest]) largest = r;
		if (largest != i){
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}

	}
}
