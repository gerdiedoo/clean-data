
class permutationSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = permutationSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int factorial(int a){
		if (a == 1 || a == 0) return 1;
		else return a * factorial(a-1);
	}

	static int [] permutationSort(int [] arr, int sizeofArr){
		int temp,check=1;
		int fact = factorial(sizeofArr);
		int maxi=0, maxi2=-1, reversePoint=-1;
		for (int i=0;i<fact;i++){
			for (int k=0;k<sizeofArr;k++) if (arr[maxi] < arr[k]) { maxi2 = maxi; maxi=k; }
			reversePoint = (int) ((maxi2+1) + (sizeofArr-(maxi2+1))/2);
			for (int k=maxi2+1;k<reversePoint;k++){
				temp = arr[k];
				arr[sizeofArr-(maxi2+1-k)] = arr[k];
				ar[sizeofArr-(maxi2+1-k)] = temp;
			}
			check = 0;
			for (int a=0;a<sizeofArr;a++) if (arr[a] > arr[a+1]) { check=1; break; }
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
