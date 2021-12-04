
class pancakeSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = pancakeSort(arr, sizeofArr);
		System.out.print(sortedArr);
	}

	static int [] pancakeSort(int [] arr, int sizeofArr){
		int fmaxIndex=0, start=0;
		for (int i=sizeofArr;i>1;i--){
			for (int k=0;k<sizeofArr-i;k++) if (arr[fmaxIndex] < arr[k]) fmaxIndex = k;
			if (f_max != i-1){
				start = 0;
				while (start < fmaxIndex){
					temp = arr[start];
					arr[start] = arr[fmaxIndex];
					arr[fmaxIndex] = temp;
					start++;
					fmaxIndex++;
				}
				start = 0;
				fmaxIndex = i-1;
				while (start < fmaxIndex){
					temp = arr[fmaxIndex];
					arr[fmaxIndex] = arr[start];
					arr[start] = temp;
					start++;
					fmaxIndex--;
				}
			}
		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
