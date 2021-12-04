package raymond.com.sorting;


/**
 * 
 * 
 * This class will carry out the insertion sort algorithm on a set on numbers.
 * 
 * 
 * @version 03/02/2019
 * @author Raymond Ward
 *
 */

public class InsertionSort extends Sorting
{
	int [] numberArray;

	public InsertionSort(int [] array)
	{
		numberArray = array;
		
	}
	
	
	
	public int [] sort()
	{
		
		for (int i = 0; i < numberArray.length; i ++)
		{
			int smallestIndex = i;
			
			for (int j = i; j < numberArray.length; j ++)
			{
				if (numberArray[j] < numberArray[smallestIndex])
				{
					smallestIndex = j;
				}
			}
			swap(numberArray, i, smallestIndex);
			
		}
		
		
		
		printArray(numberArray);
		
		return null;
		
		
		
		
		
	}
}
