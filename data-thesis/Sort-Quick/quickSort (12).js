/* Explanation
  This algorithm is an in-place (double) recursive operation that
    employs a divide-and-conquer approach.

  1) Select a value from the dataset, usually the last value, which is hopefully
    somewhere mid-range of the dataset, as the Pivot.
  2) Select an Index to the begining of the dataset.
  3) Traverse the values in the dataset (except the Pivot) and move all values,
      less than the Pivot, infront of the Index. Alternatively, you can swap the
      selcted value with that at the Index, in an action known as partitioning,
      and move the Index right towards the Pivot.
  4) Replace the Index value with the Pivot. The dataset is now in three selects:
      Values below that of the Pivot, the Pivot, and values equal to or greater
      than the Pivot.
  5) With each of the two sides of the Pivot, whilst there is more than one value,
      repeat the procdure from begining.
*/

function quickSort (arrData) {
  'use strict'

  function _swap (arrData, numSrc, numTgt) {
    let swap = arrData[numSrc]
    arrData[numSrc] = arrData[numTgt]
    arrData[numTgt] = swap
  }

  function _partition (arrData, numStart, numEnd) {
    let pivot = arrData[numEnd]
    let pIndex = numStart
    for (let idx = numStart; idx < numEnd; idx++) {
      if (arrData[idx] <= pivot) {
        _swap(arrData, idx, pIndex++)
      }
    }
    _swap(arrData, pIndex, numEnd)
    return pIndex
  }

  function _quickSort (arrData, numStart, numEnd) {
    if (numStart < numEnd) {
      const pIndex = _partition(arrData, numStart, numEnd)
      _quickSort(arrData, numStart, pIndex - 1)
      _quickSort(arrData, pIndex + 1, numEnd)
      console.log('Cycle:', arrData.join())
    }
  }

  console.log('Initial:', arrData.join(), `[Count:${arrData.length}]`)
  _quickSort(arrData, 0, arrData.length - 1)
  console.log('Final:', arrData.join())
  return arrData
}
