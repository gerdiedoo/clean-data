/* Explanation
*/

function combSort (arrData) {
  'use strict'
  const dataMax = arrData.length
  let gap = dataMax
  let shrink = 1.3
  let sorted = false

  function _swap (src, tgt) {
    let swp = arrData[src]
    arrData[src] = arrData[tgt]
    arrData[tgt] = swp
  }

  console.log('Initial:', arrData.join(), `[Count:${dataMax}]`)
  while (!sorted) {
    gap = Math.floor(gap / shrink)
    sorted = (gap <= 1)
    if (sorted) { gap = 1 }
    let loop = 0
    while (loop + gap < dataMax) {
      if (arrData[loop] > arrData[loop + gap]) {
        _swap(loop, loop + gap)
        sorted = false
      }
      loop++
    }
    console.log('Cycle:', arrData.join())
  }
  console.log('Final:', arrData.join())
  return arrData
}
