/* Explanation
*/

function bitonicSortN (arrData) {
  'use strict'
  const ASCEND = true

  const _bitonicResize = (size) => Math.pow(2, Math.floor(Math.log2(size - 1)))

  function _bitonicExchange (src, tgt) {
    let swp = arrData[src]
    arrData[src] = arrData[tgt]
    arrData[tgt] = swp
  }

  function _bitonicSort (lo, dataMax, order) {
    if (dataMax > 1) {
      let dataSplit = Math.floor(dataMax / 2)
      console.log('Cycle:', arrData.join(), `[${lo}, ${dataMax}, ${dataSplit}]`)
      _bitonicSort(lo, dataSplit, !order)
      _bitonicSort(lo + dataSplit, dataMax - dataSplit, order)
      _bitonicMerge(lo, dataMax, order)
    }
  }

  function _bitonicMerge (lo, dataMax, order) {
    if (dataMax > 1) {
      let dataSplit = _bitonicResize(dataMax)
      let hi = lo + dataMax - dataSplit
      console.log('Merge:', arrData.slice(lo, hi).join(), `[${lo}, ${hi}, ${dataMax}, ${dataSplit}]`)
      for (let loop = lo; loop < hi; loop++) {
        _bitonicCompare(loop, loop + dataSplit, order)
      }
      _bitonicMerge(lo, dataSplit, order)
      _bitonicMerge(lo + dataSplit, dataMax - dataSplit, order)
    }
  }

  function _bitonicCompare (src, tgt, order) {
    console.log('Compare In:', arrData.join())
    if (order === (arrData[src] > arrData[tgt])) _bitonicExchange(src, tgt)
    console.log('Compare Out:', arrData.join())
  }

  console.log('Initial:', arrData.join(), `[${arrData.length}]`)
  _bitonicSort(0, arrData.length, ASCEND)
  return arrData
}
