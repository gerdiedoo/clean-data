/* Explanation
  This algorithm uses an intermediate array to Count the instances of each unsorted data value, forming a histogram.
  It uses the Count array as an index to populate on output array to retain the original order of like-keys.
  To form the index from the histogram then is another pass over the Countign array to offset the locations from the counts.

  1) Prepare an intermediate (Counting) array initialised with zeros
  	for the full range of the data being sorted.
  2) Count the instances of each unsorted value.
  3) Populate the output array with values from the unsorted dataset,
  	guided by the counting array to provide the output location.
*/

function countingSort (arrData) {
  'use strict'

  const max = arrData.reduce((a, b) => Math.max(a, b))
  let count = Array(max).fill(0)
  arrData.forEach((x, i) => count[x]++)

  let total = 0
  count.forEach((x, i) => (count[i] = (total += x)))
  count.push(total)

  let output = []
  arrData.forEach((x, i) => (output[--count[x]] = x))
  return output
}
