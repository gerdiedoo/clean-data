/* Explanation
  This algorithm is an in-place non-recursive operation.
  The operation uses nested loops to traverse the dataset several times.
  The algorithm gets its name from the way values larger than the current value
    are shuffled right to the smaller value can be inserted in the gap formed.

  1) Outer Loop: Loops through all values in the dataset.
  2) Preserve the current value and the index of its position in the array
  3) Inner Loop: Traverse back through the array from the current index,
    until back at the begining or a value less than the preserved value is found.
    3a) At each cycle of the inner loop shuffle the value up the array by assigning
      the value of the previous index to the current index.
  4) Replace the value of the resting position with the preserved value.
*/

function insertionSort (arrData) {
  'use strict'
  let dataMax = arrData.length
  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  for (let indexA = 1; indexA < dataMax; indexA++) {
    console.log(arrData.join())
    const indexB = arrData[indexA]
    let indexC = indexA
    while (indexC > 0 && arrData[indexC - 1] > indexB) {
      arrData[indexC] = arrData[--indexC]
    }
    arrData[indexC] = indexB
    console.log('Cycle:', arrData.join())
  }
  console.log('Final:', arrData.join())
  return arrData
}
