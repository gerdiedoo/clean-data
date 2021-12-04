/*
 * Bubblesort.js
 * Implementation of the Bubblesort algorithm for sorting.
 */

// Swap array (A) elements at indices u and v. 
function swap(A, u, v) {
    var temp = A[u];
    A[u] = A[v];
    A[v] = temp;

    return;
}

/*
 * Compare adjacent list elements and exchange the values if they
 * are out of order.
 */
function Bubblesort(A) {
    a_len = A.length;

    for(var i = 0; i < a_len-1; i++) {
        for(var j = 0; j < a_len-1-i; j++) {
            if (A[j+1] < A[j]) {
                swap(A, j, j+1);
            }
        } 
    }

    return A;
}

// Sample data for testing.
var X = [5,21,40,11,3,1,7,2,4,6,10,18,9,8];
console.log(X);

// Call the function to test.
Bubblesort(X);
console.log(X);