/* Explanation
  This algorithm is a recursive operation that uses a divide-and-conquer approach.

  Mergining involves combining two stacks into a single stack using a rule.
  In this sort the rule is, lowest value first, until one stack is exhausted.
    Then the remaining stack in appended to the end. This algorithm assuems each
    stack is sorted, which is acheived by performing the process on sub-divided stacks.

  1) Split the dataset in two, whilst there is more than one element in the dataset.
  2) Perform the mergeSort operation on each half and then merge the results.
  3) Merge lists A and B:
    3a) With a maximum of 2 unsorted values, sort them in value order.
    3b) With more than 2 (sorted) values, combine them in sorted sequence.
*/

function mergeSort (arrData) {
  'use strict'
  const dataMax = arrData.length

  function merge (arrA, arrB) {
    let arrC = []
    while (arrA.length && arrB.length) {
      if (arrA[0] > arrB[0]) {
        arrC.push(arrB.shift())
      } else {
        arrC.push(arrA.shift())
      }
    }
    return arrC.concat(arrA).concat(arrB)
  }

  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  if (dataMax > 1) {
    // Split the source array in two
    let indexA = Math.floor(dataMax / 2)
    let indexB = arrData.slice(0, indexA)
    let indexC = arrData.slice(indexA)
    console.log('Final:', arrData.join())
    return merge(mergeSort(indexB), mergeSort(indexC))
  } else {
    console.log('Cycle:', arrData.join())
    return arrData
  }
}
