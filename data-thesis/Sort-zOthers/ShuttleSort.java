package raymond.com.sorting;

/**
 * 
 * 
 * This class will carry out the shuttle sort sort algorithm on a set on numbers.
 * 
 * 
 * @version 03/02/2019
 * @author Raymond Ward
 *
 */

public class ShuttleSort extends Sorting
{
	private int [] numberArray;
	
	
	public ShuttleSort(int [] array)
	{
		numberArray = array;
		
	}
	
	public int [] sort()
	{
		int comps  = 0 ;
		int swaps = 0;
		
		
		for (int i = 0; i < numberArray.length -1; i ++ )
		{
			comps++;
			if (numberArray[i] > numberArray[i+1])
			{
				swap(numberArray,i,i+1);
				swaps++;
				
				if (i > 0)
				{
				
					for (int j = i; j > 0; j--)
					{
						comps++;
						if (numberArray[j-1] > numberArray[j])
						{
							swap(numberArray,j,j-1);
							swaps++;
						}
						else
						{
							break;
						}
					
				
					}
				}
				
			}
			
		}
		
		
		System.out.println(comps + "comparisons");
		System.out.println(swaps + "swaps");
		return numberArray;
	}
	
	
		
}



