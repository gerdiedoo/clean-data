
public class sort {
	public void exchange (int[] numbers) {
		int temp;  //be sure that the temp variable is the same "type" as the array
		for (int i = 0; i < numbers.length - 1; i++)  {
			for (int j = i + 1; j < numbers.length; j++) {
				if(numbers[i] > numbers[j])         //sorting into descending order
				{
					temp = numbers[i];   //swapping
					numbers[i] = numbers[j];
					numbers[j] = temp; 
				}           
			}
		}
	}	
	
	
	public void bubble(int[] numbers) {
		int i, temp;
		boolean flag = true;   // set flag to true to begin first pass
	
		while (flag) {
			flag = false;    //set flag to false awaiting a possible swap
			for(i = 0; i < numbers.length -1; i++)
			{
				// change to > for ascending sort
				if(numbers[i] > numbers[i + 1]) {
					temp = numbers[i];                //swap elements
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					flag = true;              //shows a swap occurred 
				}
			}
		}
	}
	
	public int[] selection (int [] numbers) {
		int first, temp;
		for (int i = 0; i < numbers.length; i++) {
			first = 0;   //initialize to subscript of first element

			// locate smallest element between positions 1 and i.
			for(int j = 1; j <= i; j ++) {
				// switch to "<" for descending order   
				if(numbers[j] > numbers[first]) first = j;
			}
			temp = numbers[first]; //swap smallest found with element in position i.
			numbers[first] = numbers[i];
			numbers[i] = temp;
		}
		return numbers;
	}
	
	public void insertion(int [] numbers) {
		int j, i;
		int key;

		// Start with 1 (not 0)
		for (j = 1; j < numbers.length; j++) {
				key = numbers[j];
				for(i = j - 1; (i >= 0) && (numbers[i] < key); i--) {
				// Smaller values are moving up
					numbers[i + 1] = numbers[i];
			}
			numbers[i + 1] = key;    // Put the key in its proper location
		}
	}

}
