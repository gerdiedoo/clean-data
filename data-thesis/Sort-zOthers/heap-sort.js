function percolateDown(array, node, currentSize){
    let temp = array[node];

    while ( (node + 1) * 2 - 1 <= currentSize )
    {
        let child = (node + 1) * 2 - 1; //left child
        
        if ( child != currentSize && array[child + 1] > array[child] )
            child++;
        if ( array[child] > temp )
            array[node] = array[child];
        else
            break;

        node = child;
    }
    array[node] = temp;
}

function deleteMin(array, currentSize){    
    let min = array[0];
    array[0] = array[currentSize--];
    percolateDown(array, 0, currentSize);
    array[currentSize + 1] = min;
}

function heapify(array, currentSize){
    for (let i = Math.floor(currentSize/2); i >= 0; i--)
        percolateDown(array, i, currentSize);
}

function sort(array){
    let currentSize = array.length - 1;
    
    heapify(array, currentSize);

    while ( currentSize > 0 )
        deleteMin(array, currentSize--);
}
