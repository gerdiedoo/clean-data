import java.util.Random;

class randomSort
	public static void main(String [] args){
		int [] arr = {1, 3, 5, 6, 6, 1, 3, 5};
		int sizeofArr = arr.length;
		int [] sortedArr = new int [sizeofArr];
		sortedArr = randomSort(arr, sizeofArr);
		print(sortedArr);
	}

	static int [] randomSort(int [] arr, int sizeofArr){
		int randIndex;
		boolean check=1;
		boolean [] checkArr = new boolean [sizeofArr];
		while (check){
			for (int a=0;a<sizeofArr;a++) checkArr[a] = 0;//create zero arr
			for (int i=0;i< (int) (sizeofArr/2);i++){
				randIndex = rand.Next(0, sizeofArr);
				if (checkArr[randIndex] == 0){
					temp = arr[randIndex];
					arr[randIndex] = arr[i];
					arr[i] = temp;
				}
			}
			check = 0;
			for (int k=0;k<sizeofArr;k++) if (arr[k] > arr[k+1]) { check = 1; break; }

		}
		return arr;
	}

	static void print (int [] arr){
		for (int a : arr)
		System.out.print(" "+a);
	}
}
