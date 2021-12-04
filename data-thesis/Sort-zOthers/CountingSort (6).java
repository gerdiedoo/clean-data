package Java;

public class CountingSort extends Sort{
	
	public static void main(String[] args){
		int[] data = buildDataSet(5);
		
		timeSort(new CountingSort(), data);
	}
	
	public CountingSort(){ super("Counting"); }
		
	private void countingSort(int[]data){
	    int[] output = new int[data.length];
	    int max = max(data);
	    int min = min(data);
	    int minAbs = Math.abs(min);

	    if ( min > 0 )
	    {
	        min = 0;
	        minAbs = 0;
	    }

	    int[] counts = new int[minAbs + max + 1];

	    //count
	    for (int i = 0; i < data.length; i++)
	        counts[data[i] + minAbs]++;

	    //cumulative sum
	    for (int i = 1; i < counts.length; i++)
	        counts[i] += counts[i-1];

	    //map
	    for (int i = data.length - 1; i >= 0; i--)
	    {
	        output[counts[data[i] + minAbs] - 1] = data[i];
	        counts[data[i] + minAbs]--;
	    }

	    for (int i = 0; i < data.length; i++)
	        data[i] = output[i];
	}
	
	private int max(int[] data){
		int currentMax = data[0];
		
		for (int i = 1; i < data.length; i++)
			if ( data[i] > currentMax )
				currentMax = data[i];
		
		return currentMax;
	}
	
	private int min(int[] data){
		int currentMin = data[0];
		
		for (int i = 1; i < data.length; i++)
			if ( data[i] < currentMin )
				currentMin = data[i];
		
		return currentMin;
	}
	
	@Override
	public void sort(int[] data){
		countingSort(data);
	}
}
