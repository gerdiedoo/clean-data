import java.lang.Math;

class radixSort
	public static void main(String [] args){
		int [] arr = {1, 23, 415, 16, 46,51, 93, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = sort(arr, sizeofArr);
	}

	static int [] sort(int [] arr, int n){
		int a1=0,a2=0,temp=0;
		int max = getMax(arr, n);
		for (int j=0; max>0){
			for (int i=0;i<n;i++){
				for (int k=0;k<n;k++){
					a1 = (arr[i]%Math.pow(10,j+1))/(Math.pow(10,j));
					a2 = (arr[i+1]%Math.pow(10,j+1))/(Math.pow(10,j));
					if (a1 < a2){
						temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
				}
			}
			max /= 10;
		}
		return arr;
	}

	static int getMax(int [] arr, int n){
		int max = 0;
		for (int i=0;i<n;i++)
			if (max < arr[i]) max = arr[i];
		return max;
	}
}
