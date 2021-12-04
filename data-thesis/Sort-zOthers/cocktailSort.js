/* Explanation
procedure cocktailShakerSort( A : list of sortable items ) defined as:
  do
  swapped := false
  for each i in 0 to length( A ) - 2 do:
  if A[ i ] > A[ i + 1 ] then // test whether the two elements are in the wrong order
  swap( A[ i ], A[ i + 1 ] ) // let the two elements change places
  swapped := true
  end if
  end for
  if not swapped then
  // we can exit the outer loop here if no swaps occurred.
  break do-while loop
  end if
  swapped := false
  for each i in length( A ) - 2 to 0 do:
  if A[ i ] > A[ i + 1 ] then
  swap( A[ i ], A[ i + 1 ] )
  swapped := true
  end if
  end for
  while swapped // if no elements have been swapped, then the list is sortedend procedure
*/

function cocktailSort (arrData) {
  'use strict'
  function _swap (arrData, numSrc, numTgt) {
    let swap = arrData[numSrc]
    arrData[numSrc] = arrData[numTgt]
    arrData[numTgt] = swap
    console.log('Cycle:', arrData.join())
    return true
  }

  let swapped = false
  let dataMax = arrData.length
  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  do {
    swapped = false
    for (let loop = 0; loop < dataMax - 1; loop++) {
      if (arrData[loop] > arrData[loop + 1]) {
        swapped = _swap(arrData, loop, loop + 1)
      }
    }
    if (swapped) {
      swapped = false
      for (let loop = (dataMax - 2); loop >= 0; loop--) {
        if (arrData[loop] > arrData[loop + 1]) {
          swapped = _swap(arrData, loop, loop + 1)
        }
      }
    }
  } while (swapped)
  console.log('Final:', arrData.join())
  return arrData
}
