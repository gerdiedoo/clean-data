package Java;

public class ShellSort extends Sort{
	
	public static void main(String[] args){
		int[] data = buildDataSet(5);
		
		timeSort(new ShellSort(), data);
	}
	
	public ShellSort(){ super("Shell"); }
	
	private void shellSort(int[] data){
	     for( int gap = data.length/2; gap > 0; gap /= 2 ) // determine sequence
	         for( int i = gap; i < data.length; i++ )
	         {
	             int temp = data[i]; // create hole
	             
	             //slide greater elements down
	    	     int j;
	             for(j = i; j >= gap && data[j-gap] > temp; j -= gap )
	            	 data[j] = data[j-gap];
	             
	             data[j] = temp;
	         }
	}
	
	@Override
	public void sort(int[] data){	     
		shellSort(data);
	}
}
