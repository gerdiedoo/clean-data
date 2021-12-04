package Java;

public class HeapSort extends Sort{
	
	public static void main(String[] args){
		int[] data = buildDataSet(5);
		
		timeSort(new HeapSort(), data);
	}
	
	public HeapSort(){ super("Heap"); }
	
	private void deleteMin(int[] data, int currentSize){    
	    int min = data[0];
	    data[0] = data[currentSize--];
	    percolateDown(data, 0, currentSize);
	    data[currentSize + 1] = min;
	}

	private void heapify(int[] data, int currentSize){
	    for (int i = currentSize/2; i >= 0; i--)
	        percolateDown(data, i, currentSize);
	}

	private void percolateDown(int[] data, int node, int currentSize){
	    int temp = data[node];

	    while ( (node + 1) * 2 - 1 <= currentSize )
	    {
	        int child = (node + 1) * 2 - 1; //left child
	        
	        if ( child != currentSize && data[child + 1] > data[child] )
	            child++;
	        if ( data[child] > temp )
	            data[node] = data[child];
	        else
	            break;

	        node = child;
	    }
	    data[node] = temp;
	}
	
	@Override
	public void sort(int[] data){
	    int currentSize = data.length - 1;
	    
	    heapify(data, currentSize);

	    while ( currentSize > 0 )
	        deleteMin(data, currentSize--);
	}
}
