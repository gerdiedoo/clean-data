package ie.gmit.dip;
import java.util.Random;

public class BogoSort {
	public static void main(String[] args)
	{
	    // TODO code application logic here
	    //Random array to be sorted here
        Random g = new Random();
        
       int [] number = new int [10]; //alternated and run 10 times manually

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(number.length)+1;
            number[d] = RandomG;
            System.out.print(" " +RandomG);
        }
		
	    long startTime= System.nanoTime();
 
		BogoSort now=new BogoSort();
		System.out.println(" ");
		now.display1D(number);
 
		now.bogo(number);
 
        System.out.println(" ");
		System.out.print("Sorted: ");
		now.display1D(number);
		
		long endTime= System.nanoTime();
        long elapsed = endTime-startTime; 
        double timeMillis= elapsed/1000000.0;
        System.out.print("\nSorted In: "+ timeMillis );
        System.out.print("\n" );
	}
	void bogo(int[] number)
	{
		//Keep a track of the number of shuffles
		int shuffle=1;
		for(;!isSorted(number);shuffle++)
			shuffle(number);
		//Boast
		System.out.println("This took "+shuffle+" shuffles.");
	}
	void shuffle(int[] number)
	{
		//Standard Fisher-Yates shuffle algorithm
		int i=number.length-1;
		while(i>0)
			swap(number,i--,(int)(Math.random()*i));
	}
	void swap(int[] number,int i,int j)
	{
		int temp=number[i];
		number[i]=number[j];
		number[j]=temp;
	}
	boolean isSorted(int[] number)
	{
 
		for(int i=1;i<number.length;i++)
			if(number[i]<number[i-1])
				return false;
		return true;
	}
	void display1D(int[] number)
	{
		for(int i=0;i<number.length;i++)
			System.out.print(number[i]+" ");
		System.out.println(" ");
	}
 
}