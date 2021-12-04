package piratezpdx.sortathon;

/***************************************************************
 * Created by piratezpdx on 12/11/14.
 *
 * Selection Sort
 *
 * data structure of choice:
 *  - array
 *
 * advantages:
 *  - sort in place
 *
 * big O
 *  - n squared
 *  - specifically: n(n-1)/2
 *
 * pseudo code:
 * for i = 1 to n
 *  - select the ith element and store it in a temporary variable
 *  - for j = i+1 to n
 *    - if the temp variable is greater than the jth element
 *      + swap all the things as follows:
 *      + put the jth element in the ith slot
 *      + put the temp variable in the jth slot
 *      + put the ith element in the temp variable
 *
 *****************************************************************/

public class Selection extends ArrayBased {

    Selection(){
        super();
    }

    public int sort() throws ArrayIndexOutOfBoundsException{
        int count = 0;
        int focus_element = 0;
        int current_element = 0;
        int comparison_number = 0;
        int array_length = sortingArray.length;

        if (array_length < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }

        while (focus_element < array_length){
            comparison_number = sortingArray[focus_element];
            current_element = focus_element +1;
            while (current_element < array_length){
                if(comparison_number > sortingArray[current_element]){
                    sortingArray[focus_element] = sortingArray[current_element];
                    sortingArray[current_element] = comparison_number;
                    comparison_number = sortingArray[focus_element];
                    // this.display(); // watch while I sort can be cool
                } // end if
                current_element++;
                count++;
            } // end inner while
            focus_element++;
        } // end outer while
        return count;                   // n(n-1)/2
    } // end method
}
