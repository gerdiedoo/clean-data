/* Explanation

  A divide-and-conquer approach that incrementaly groups values according to
    the value at shifting significant positions.
  The 'shifting' is performed through a recursive call.
*/
'use strict'

function radixSort (arrData = [], idx = 0) {
  let arrGrouped = []
  let arrSorted = []
  let radix
  let max = (10 ** (idx + 1))
  let min = (10 ** idx)
  let blnMoreToProcess = false
  arrData.forEach(item => {
    if (!blnMoreToProcess && (item >= max)) {
      blnMoreToProcess = true
    }
    radix = Math.floor((item % max) / min)
    if (arrGrouped[radix] === undefined) {
      arrGrouped[radix] = []
    }
    arrGrouped[radix].push(item)
  })
  arrGrouped.forEach(group => {
    if (group !== undefined) {
      arrSorted = arrSorted.concat(group)
    }
  })
  return blnMoreToProcess ? radixSort(arrSorted, ++idx) : arrSorted
}
