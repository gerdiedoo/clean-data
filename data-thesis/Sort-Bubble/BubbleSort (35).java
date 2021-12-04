package raymond.com.sorting;

/**
 * 
 * 
 * This class will carry out the bubble sort algorithm on a set on numbers.
 * 
 * 
 * @version 03/02/2019
 * @author Raymond Ward
 *
 */

public class BubbleSort extends Sorting
{
	private int [] numberArray;
	
	
	public BubbleSort(int [] array)
	{
		numberArray = array;
		
	}
	
	public int [] sort()
	{
		int swaps = 0;
		int comps = 0;
		for (int i = 0; i < numberArray.length; i ++)
		{
			for (int j = 0; j < numberArray.length - 1; j ++ )
			{
				comps++;
				if (numberArray[j] > numberArray[j+1])
				{
				swap(numberArray,j,j+1);
				swaps++;
				}
			}
		}
		System.out.println(comps + "comparisons");
		System.out.println(swaps + "swaps");
		return numberArray;
	}
	
	

}
