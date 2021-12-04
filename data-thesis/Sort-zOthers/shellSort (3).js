/* Explanation
  This algorithm is an in-place no-recursive operation that
    employs a two-stage process, the later with 3 nested loops..

  1) Primary loop: Calculates the Gap by splitting the dataset in thirds.
  2) Outer Loop: Reduce the Gap in a sequcne for 1/3s each cycle.
  3) Middle Loop (ML): Travers the values from 1/3 in to the dataset to the end.
  4) Preserve the:
    4a) value of the Current ML Index,
    4b) ML Index itself,
    4c) ML Index less the Gap.
  5) Inner Loop: while the ML Index is greater than just short of the Gap and,
    Preserved value is less than that of the
    5a) Set the value at the ML Index to that of (ML Index less the Gap).
    5b) Reduce the ML Index by the Gap.
  6) Set the value of the Calculates Index to the Preserved value.
*/

function shellSort (arrData) {
  'use strict'
  let indexA = 1
  const dataMax = arrData.length

// 1 4 13 40 (equals 120/3)
  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  while (indexA < (dataMax / 3)) {
    indexA = indexA * 3 + 1
  }
  while (indexA > 0) {
    for (let indexB = indexA; indexB < dataMax; indexB++) {
      let indexC = arrData[indexB]
      let indexD = indexB
      let indexE = indexD - indexA
      while (indexD > indexA - 1 && arrData[indexE] >= indexC) {
        arrData[indexD] = arrData[indexE]
        indexD = indexE
        indexE = indexD - indexA
      }
      arrData[indexD] = indexC
      console.log('Cycle:', arrData.join())
    }
    indexA = (indexA - 1) / 3
  }
  console.log('Final:', arrData.join())
  return arrData
}
