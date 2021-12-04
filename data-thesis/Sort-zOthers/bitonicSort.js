/* Explanation
def bitonic_sort(up, x):
  if len(x) <= 1:
  return x
  else:
  first = bitonic_sort(True, x[:len(x) / 2])
  second = bitonic_sort(False, x[len(x) / 2:])
  return bitonic_merge(up, first + second)

def bitonic_merge(up, x):
  # assume input x is bitonic, and sorted list is returned
  if len(x) == 1:
  return x
  else:
  bitonic_compare(up, x)
  first = bitonic_merge(up, x[:len(x) / 2])
  second = bitonic_merge(up, x[len(x) / 2:])
  return first + second

def bitonic_compare(up, x):
  dist = len(x) / 2
  for i in range(dist):
  if (x[i] > x[i + dist]) == up:
  x[i], x[i + dist] = x[i + dist], x[i] #swap

*/

function bitonicSort (arrData) {
  'use strict'
  const ASCEND = true
  const DESCEND = false

  function _bitonicSort (order, arrData) {
    console.log('Cycle:', arrData.join())
    let dataMax = arrData.length
    if (dataMax <= 1) return arrData
    let dataSplit = Math.floor(dataMax / 2)
    let first = _bitonicSort(ASCEND, arrData.slice(0, dataSplit))
    let second = _bitonicSort(DESCEND, arrData.slice(dataSplit))
    return _bitonicMerge(order, first.concat(second))
  }

  function _bitonicMerge (order, arrData) {
    console.log('Merge:', arrData.join())
    let dataMax = arrData.length
    if (dataMax <= 1) return arrData
    _bitonicCompare(order, arrData)
    let dataSplit = Math.floor(dataMax / 2)
    let first = _bitonicMerge(order, arrData.slice(0, dataSplit))
    let second = _bitonicMerge(order, arrData.slice(dataSplit))
    return first.concat(second)
  }

  function _bitonicCompare (order, arrData) {
    console.log('Compare In:', arrData.join())
    let dataMax = arrData.length
    let dist = Math.floor(dataMax / 2)
    for (let i = 0; i < dist; i++) {
      if ((arrData[i] > arrData[i + dist]) === order) {
        let temp = arrData[i]
        arrData[i] = arrData[i + dist]
        arrData[i + dist] = temp
      }
    }
    console.log('Compare Out:', arrData.join())
  }

  console.log('Initial:', arrData.join())
  return _bitonicSort(ASCEND, arrData)
}
