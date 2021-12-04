function countingSort(array){
    let output = new Array(array.length);
    let max = Math.max(...array);
    let min = Math.min(...array);
    let minAbs = Math.abs(min);

    if ( min > 0 )
    {
        min = 0;
        minAbs = 0;
    }

    let counts = new Array(minAbs + max + 1).fill(0);

    //count
    for (let i = 0; i < array.length; i++)
        counts[array[i] + minAbs]++;

    //cumulative sum
    for (let i = 1; i < counts.length; i++)
        counts[i] += counts[i-1];

    //map
    for (let i = array.length - 1; i >= 0; i--)
    {
        output[counts[array[i] + minAbs] - 1] = array[i];
        counts[array[i] + minAbs]--;
    }

    for (let i = 0; i < array.length; i++)
        array[i] = output[i];
}

function sort(array){
    countingSort(array);
}
