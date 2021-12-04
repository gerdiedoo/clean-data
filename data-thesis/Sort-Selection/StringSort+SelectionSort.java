//Author: Ketan Vasudeva
//Date: November 27th, 2016
//Purpose: Creates various sorting methods.
public class Sorting {
	 
	//This method sorts a given string array in alphabetical order.
	public static void SortStrings(String[] A)
	{
		//Sets the condition to true so the loops may begin and creates a variable to be used.
		boolean haveSwapped = true;
		String temp;
		
		//Loops through the array and exits method once all the necessary words have been swapped.
		while (haveSwapped == true)
		{

			haveSwapped = false;

			// Loop through the array.
			for (int i = 0; i < A.length - 1; i++)
			{
				// Check if the current element’s neighbour is smaller. If
				// so, swap them.
				if (A[i+1].compareToIgnoreCase(A[i]) < 0)
				{
					haveSwapped = true;
					temp = A[i];
					A[i] = A[i+1];
					A[i+1] = temp;
				}
			}
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

