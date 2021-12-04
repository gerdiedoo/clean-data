package ie.gmit.dip;
import java.util.Random;
import java.util.Arrays;

public class CountingSort {
    
    // Driver method 
    public static void main(String[] args) {

    
        // TODO code application logic here
        Random g = new Random();
        
        // Input & Key k (range for ‘Counting Sort’ algorithm)
        
       int [] number = new int [10000]; //alternated and run 10 times manually

        System.out.print("Random Numbers:");
        for (int d = 0 ; d<number.length ; d++){
            int RandomG = g.nextInt(number.length)+1; //Range must match key k
            number[d] = RandomG;
            System.out.print(" " +RandomG);
        }
        int k = number.length;
        
        long startTime= System.nanoTime();

        // sorting array using Counting Sort Algorithm 
        countingSort(number, k); 
        System.out.println(Arrays.toString(number));
           
        long endTime= System.nanoTime();
        long elapsed = endTime-startTime; 
        double timeMillis= elapsed/1000000.0;
        System.out.print("\nSorted In: "+ timeMillis );
        System.out.print("\n" );

    }
    

        public static void countingSort(int[] number, int k) { 
        int counter[] = new int[k + 1]; // create buckets 
        for (int i : number) { // fill buckets 
        counter[i]++;
     } 
        
        // sort array
        int sorted = 0; 
        for (int i = 0; i < counter.length; i++) { 
        while (0 < counter[i]) {
        number[sorted++] = i; 
        counter[i]--; 
            }
         }
     }
 }

   
    

