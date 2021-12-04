/*
 * InsertionSort.js
 * Implementation of the Insertion sort algorithm for sorting.
 */

function Insertionsort(A) {
    var i, v, j, a_len;
    a_len = A.length;

    // Iterate over the array.
    for (i=1; i < a_len; i++) {
        v = A[i];
        j = i - 1;

        // While index is positive and element is greater than A[i] 
        // scan and insert A[i] into its proper position.
        while ((j >= 0) && (A[j] > v)) {
            A[j+1] = A[j];
            j = j -1;
        }

        A[j+1] = v;
    }

    return A;
}

// Sample data for testing.
var X = [5,21,40,11,3,1,7,2,4,6,10,18,9,8];
console.log(X);

// Call the function to test.
Insertionsort(X);
console.log(X);
