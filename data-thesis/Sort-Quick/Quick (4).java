package piratezpdx.sortathon;

import java.util.Random;

/**
 * Created by piratezpdx on 12/18/14.
 *
 * This is the one with the pivot. Best practice is to randomize the pivot point. By doing so we
 * prevent (n)squared time in practice, although not in theoretical worst case.
 *
 * Data structure of choice:
 *  - array
 *
 * Advantages:
 *  - sort in place, fast.
 *
 * Big O:
 *  - worst case: (n)squared - theoretical
 *                n(lg(n))   - in practice (with randomized pivot and sufficiently large n)
 *
 *  - average: n(lg(n))
 *
 * Pseudo code:
 * if you only have one element in the array, return.
 * pick a random element within the array to be the pivot point
 * partition the array around the pivot element.
 *  - items smaller than the pivot go on the left.
 *  - items not smaller than the pivot go on the right.
 * recursively call yourself on the left and right partitions
 *
 *
 */
public class Quick extends ArrayBased {
    public Random pivotPoint;


    Quick() {
        super();
        pivotPoint = new Random();
    }

    // wrapper for quick sort
    public int sort (){
        return partitionRecurse(0, sortingArray.length);
    }

    // the recursive engine
    public int partitionRecurse(int startIndex, int quantity){

        // base case - we put this first to avoid a divide by zero error
        if (quantity <= 1){
            return 0;
        }

        // create new pivot point based on size of the incoming array
        // this is where we select a randomized pivot element
        int pivot = ((Math.abs(pivotPoint.nextInt()) % quantity) + startIndex);

        // other local variables
        int temp = 0;
        int count = 0;
        int i = startIndex+1;

        // swap randomized pivot point with the first element ( we will change that later )
        // makes it a little easier to step through a for loop if you do this.
        temp = sortingArray[pivot];
        sortingArray[pivot] = sortingArray[startIndex];
        sortingArray[startIndex] = temp;

        // linear scan re-arranging array into buckets where buckets contain either
        // a) items less than the pivot (swap, increment both)
        // b) items not less than the pivot (increment j)
        // lastly swap ith element with (startIndex)th element
        for (int j = startIndex; j < startIndex+quantity; j++ ){
            if (sortingArray[j] < sortingArray[startIndex]){
                temp = sortingArray[j];
                sortingArray[j] = sortingArray[i];
                sortingArray[i] = temp;
                i++;
            }
            count++;
        }

        // array is now partitioned so return the pivot element to its
        // rightful spot - which is also its exact place in the (eventually)
        // sorted array. Ah, the magics....
        temp = sortingArray[startIndex];
        sortingArray[startIndex] = sortingArray[i-1];
        sortingArray[i-1] = temp;

        // now continue to partition the array...
        count += (partitionRecurse(startIndex, i-startIndex-1));   // left sub-array
        count += (partitionRecurse(i, quantity+startIndex-i) + 1); // right sub-array
        return count;                                              // n(lg(n)) for sufficiently large n
    }

}
