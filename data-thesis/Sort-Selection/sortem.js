
module.exports = {
    //Mergesort has two steps: merging and sorting. The algorithm uses a divide-and-conquer approach to merge and sort a list.
    mergeSort: (unsortedArray) => {
        //this is the merging function, im just enclosuring in the mergeSort, it can be outside tho hahah
        function merge(left, right) {
            let resultArray = [], leftIndex = 0, rightIndex = 0;
            while (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    resultArray.push(left[leftIndex]);
                    leftIndex++;
                } else {
                    resultArray.push(right[rightIndex]);
                    rightIndex++;
                }
            }
            return resultArray.concat(left.slice(leftIndex)).concat(right.slice(rightIndex));
        }
        if (unsortedArray.length <= 1) {
            return unsortedArray;
        }
        const middle = Math.floor(unsortedArray.length / 2);
        const left = unsortedArray.slice(0, middle);
        const right = unsortedArray.slice(middle);
        return merge(
            module.exports.mergeSort(left), module.exports.mergeSort(right)
        );
    },
    //Sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning.
    selectionSort: (unsortedArray) => {

        function swap(array, firstIndex, secondIndex) {
            let aux = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = aux;
        };

        for (let i = 0; i < unsortedArray.length; i++) {
            //set min to the current iteration of i
            let min = i;
            for (let j = i + 1; j < unsortedArray.length; j++) {
                if (unsortedArray[j] < unsortedArray[min]) {
                    min = j;
                }
            }
            swap(unsortedArray, i, min);
        }
        return unsortedArray;
    },
    //algorithm follows Divide and Conquer approach. It divides 
    //elements into smaller parts based on some condition and performing the sort operations on those divided smaller parts.
    quickSort: (unsortedArray, left = 0, right = unsortedArray.length - 1) => {

        function swap(array, firstIndex, secondIndex) {
            const aux = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = aux;
        };

        function partition(items, left, right) {
            const pivot = items[Math.floor((right + left) / 2)]; //middle element
            let i = left, //left pointer
                j = right; //right pointer
            while (i <= j) {
                while (items[i] < pivot) {
                    i++;
                }
                while (items[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(items, i, j); //sawpping two elements
                    i++;
                    j--;
                }
            }
            return i;
        }
        let index;
        if (unsortedArray.length > 1) {
            index = partition(unsortedArray, left, right); //index returned from partition
            if (left < index - 1) { //more elements on the left side of the pivot
                module.exports.quickSort(unsortedArray, left, index - 1);
            }
            if (index < right) { //more elements on the right side of the pivot
                module.exports.quickSort(unsortedArray, index, right);
            }
        }
        return unsortedArray;
    },
    //builds a final sorted array, one element at a time.
    insertionSort: (unsortedArray) => {
        let length = unsortedArray.length;
        for (let i = 1; i < length; i++) {
            let key = unsortedArray[i];
            let j = i - 1;
            while (j >= 0 && unsortedArray[j] > key) {
                unsortedArray[j + 1] = unsortedArray[j];
                j = j - 1;
            }
            unsortedArray[j + 1] = key;
        }
        return unsortedArray;
    },
    // simple, inefficient sorting algorithm
    bubbleSort: (unsortedArray) => {
        let len = unsortedArray.length;
        let swapped;
        do {
            swapped = false;
            for (let i = 0; i < len; i++) {
                if (unsortedArray[i] > unsortedArray[i + 1]) {
                    let tmp = unsortedArray[i];
                    unsortedArray[i] = unsortedArray[i + 1];
                    unsortedArray[i + 1] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
        return unsortedArray;
    }




}
