package piratezpdx.sortathon;

/**
 * Created by piratezpdx on 12/18/14. * Selection Sort
 *
 * data structure of choice:
 *  - array
 *
 * advantages:
 *  - sort in place
 *
 * big O
 *  - n squared
 *  - worst case: n(n-1)/2 comparisons, but there is the overhead of copying an array.
 *
 * pseudo code:
 * for i = 2 to n
 *  - select the ith element and copy to temp
 *  - for j = 1 to i and not spot found
 *   + if temp < jth element
 *    * shift sorted portion of array to right by one
 *    * put temp into jth spot
 *    * indicate spot found
 *
 */
public class Insertion extends ArrayBased {

    Insertion(){
        super();
    }

    public int sort() throws ArrayIndexOutOfBoundsException{
        int count = 0;
        int comparison = 0;
        int focus_element = 0;
        int current_element = 0;
        int array_length = sortingArray.length;
        boolean inserted;

        if (array_length < 1){
            throw new ArrayIndexOutOfBoundsException();
        }

        for (focus_element = 1; focus_element < array_length; focus_element++){
            inserted = false;
            comparison = sortingArray[focus_element];
            for (current_element = 0; (current_element < focus_element) && !inserted; current_element++){
                if (comparison < sortingArray[current_element]){
                    System.arraycopy(sortingArray,current_element,sortingArray,current_element+1,(focus_element-current_element));
                    inserted = true;
                    sortingArray[current_element] = comparison;
                }
                count++;
            }
        }
        return count;
    }

}
