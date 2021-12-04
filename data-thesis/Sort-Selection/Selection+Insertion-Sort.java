//Author: Ketan Vasudeva
//Date: March 23rd, 2018
//Course: ICS4U1
//Purpose: Sorting algorithms
public class Sorting {

	//Creates insertion sort algorithm.
	public static void InsertionSort(String[] words)
	{
		//Initializes necessary variables.
		String key;
		int count;
		//Loops through array.
		for (int i = 1; i < words.length; i++)
		{
			//Sets key and count values.
			key = words[i];
			count = i-1;

			//Shifts array forward, inserting one item into its proper position.
			while (count >= 0 && words[count].compareToIgnoreCase(key) > 0)
			{
				words[count+1] = words[count];
				count = count-1;
			}
			//Key is set to the next value in array.
			words[count+1] = key;
		}
	}

	//This method sorts an int array in ascending order.
	public static int[] SelectionSort(int[] A)
	{
		//Creates variables to be used and the array which will be returned.
		int temp = A[0];
		int largest = A[0];
		int [] sortedNumbers = new int[A.length];

		//Loops through the new array, filling each spot. 
		for (int a = 0; a < A.length; a++)
		{
			//Finds the smallest and largest integers in the original array.
			for (int i = 0; i < A.length; i++)
			{
				if (temp > (A[i]))
				{
					temp = A[i];
				}
				if (largest < A[i])
				{
					largest = A[i];
				}
			}
			//Sets the spot in the new array to the smallest number.
			sortedNumbers[a] = temp;
			//Loops through changing the smallest number in the original array to a number larger than the largest to avoid repeats.
			for (int i = 0; i < A.length; i++)
			{
				if (A[i] == temp)
				{
					A[i] = largest + 1;
					break;
				}
			}
			//Temp is set to largest number in order to prevent repeats.
			temp = largest;
		}
		//Returns the new array.
		return sortedNumbers;	
	}

}



