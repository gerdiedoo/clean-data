package piratezpdx.sortathon;

/***************************************************************
 * Created by piratezpdx on 12/27/14.
 *
 * Merge Sort
 *
 * data structure of choice:
 *  - array
 *
 * advantages:
 *  - lowest theoretical run time.
 *  - always fast, if you have the memory.
 *
 * big O:
 *  - n(lg(n))
 *  - I am counting number of times the comparison cycle goes through
 *  - and so this is always n(lg(n)) rather than only number of internal
 *  - element comparisons, which yields less than n(lg(n)).
 *
 * pseudo code:
 *
 * subdivision
 *  - if you are a single element, return yourself as you are now sorted.
 *
 *  - split the array in half
 *  - recurse on each of the subdivided portions
 *  - merge the two sudivided portions into one and
 *  - return the merged array
 *
 * merge
 *  - make a new array of the appropriate size
 *
 *  - start at the beginning of each incoming array
 *  - and examine the two elements in question. The smaller
 *  - element goes in the new array. Advance the new array index
 *  - and the index of the array that contained the smaller element.
 *
 *  -repeat until all elements of each array have been copied
 *  - return the resulting array.
 *
 *****************************************************************/

public class Merge extends ArrayBased {
    protected int comparisons;

    // constructor
    Merge(){
        super();
        comparisons = 0;
    }

    // wrapper
    public int sort(){
        comparisons = 0;
        setSortingArray(split(getSortingArray()));
        return comparisons;
    }

    // subdivide the array into two parts, acccount for odd numbers
    // recurse on subdivision aspect until single values.
    // call merge on the subdivided arrays on the way out returning that array
    public int[] split(int[] incoming)throws ArrayIndexOutOfBoundsException{
        int leftlen = 0;
        int rightlen = 0;

        // base case
        if (incoming.length == 1){
            return incoming;
        }

        // even or odd length array
        if (incoming.length%2 == 0){
            leftlen = rightlen = incoming.length/2;
        }
        else{
            leftlen = incoming.length/2;
            rightlen = leftlen + 1;
        }

        // malloc the subdivisions and copy accordingly
        int [] left = new int[leftlen];
        int [] right = new int[rightlen];

        System.arraycopy(incoming, 0, left, 0, leftlen);
        System.arraycopy(incoming, leftlen, right, 0, rightlen);

        // the real magic begins here as each of these becomes
        // a sorted subdivision by virtue of the upcoming merge call...
        left = split(left);
        right = split(right);

        return mergeThese(left,right);
    }

    // the merging and sorting of arrays
    public int[] mergeThese(int[] a, int[] b) throws ArrayIndexOutOfBoundsException{
        int num = 0;
        int aIndex = 0;
        int bIndex = 0;
        int aLen = a.length;
        int bLen = b.length;
        int resultLen = aLen + bLen;
        int [] result = new int [resultLen];

        // we make the index checks first to prevent array bounds violations
        while (num < resultLen){
            // all values in array a have been copied
            if (aIndex == aLen) {
                System.arraycopy(b, bIndex, result, num, 1);
                bIndex++;
            }
            // all values in array b have been copied
            else if (bIndex == bLen){
                System.arraycopy(a, aIndex, result, num, 1);
                aIndex++;
            }
            // neither array has been exhausted, so we are forced to compare
            else if (a[aIndex] < b[bIndex]){
                System.arraycopy(a, aIndex, result, num, 1);
                aIndex++;
            }
            else{
                System.arraycopy(b, bIndex, result, num, 1);
                bIndex++;
            }
            num++;      // increment result marker
            this.comparisons++;
        }
        return result;
    }
}
