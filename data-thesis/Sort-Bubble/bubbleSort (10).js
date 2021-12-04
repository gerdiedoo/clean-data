/* Explanation
  This algorithm is an in-place non-recursive operation.
  The operation uses nested loops to traverse the dataset several times.
  The algorithm gets its name from the way the highest values bubble up to the
  top (right-hand end) of the dataset.

  1) Outer Loop: Loop until no swaps are performed by the inner loop.
  2) Inner Loop: Loop through each value of the dataset, starting each cycle
    from the point where the previous cycle finished swapping.
  3) Compare each value with its next neighbour, swapping them if greater-than
    its neighbour.
*/

function bubbleSort (arrData) {
  'use strict'
  function _swap (arrData, numSrc, numTgt) {
    let swap = arrData[numSrc]
    arrData[numSrc] = arrData[numTgt]
    arrData[numTgt] = swap
  }

  let indexA = arrData.length
  console.log('Initial:', arrData.join(), `[Count:${indexA}]`)
  do {
    let indexB = 0
    for (let indexC = 0; indexC < indexA; indexC++) {
      if (arrData[indexC] > arrData[indexC + 1]) {
        _swap(arrData, indexC, indexC + 1)
        indexB = indexC
      }
    }
    indexA = indexB
    console.log('Cycle:', arrData.join())
  } while (indexA > 0)
  console.log('Final:', arrData.join())
  return arrData
}
