/* Explanation
  This algorithm is an in-place operation, although it may not appear so as it
    employs a divide-and-conquer approach using a binary heap.
    A binary heap consists of a cascade of triads (groups of three values,
      parent with up to two children). Each triad is arranged so the highest
      value is in the parent slot, with each child the potential parent of another
      triad.
  The essential functions include as swap utility plus:
    fnChildId: Given the index of the parent and the direction of the child
      (LEFT or RIGHT), it returns the index of the child.
    fnBalanceTriad: Arranges a group of upto three values so the parent has the
      highest value of the three.
    fnBalanceHeap: Used when the Sort commences to ensure a consistent heap is
      established using the fnBalanceTriad function.
    fnRemoveHead: Reduced the size of the Heap by moving the Head (top parent),
      which is the highest value in the Heap, out to build a sorted list.

  1) Balance the entire Heap by repeatedly balancing each triad (bottom up) until
    no triads need balancing. At this point the highest value is at the top.
  2) Move the Head (top parent value) out of the Heap to prepend a list of sorted values.
  3) Re-balance the Heap by placing the last value in the Heap at the Head and
    re-balance each Triad, following the path of the exchanged child until either,
    there are no more children or no exchange is required.
*/

function heapSort (arrData) {
  'use strict'
  let numTail = arrData.length - 1  // Reference to last element
  const NEED_CHANGE = 1
  const NO_CHANGE = 0
  const LEFT_CHILD = 1
  const RIGHT_CHILD = 2

  function fnSwap (idx1, idx2) {
    let swap = arrData[idx1]
    arrData[idx1] = arrData[idx2]
    arrData[idx2] = swap
  }

  const fnChildId = (parentId, side) => {
    let childId = (parentId * 2) + side
    return (childId <= numTail) ? childId : NO_CHANGE
  }

  function fnBalanceTriad (parentIdx) {
    let numBalanced = NO_CHANGE
    let leftChild = fnChildId(parentIdx, LEFT_CHILD)
    if (leftChild) {
      let rightChild = fnChildId(parentIdx, RIGHT_CHILD)
      if (rightChild &&
        (arrData[parentIdx] < arrData[rightChild]) &&
        (arrData[leftChild] < arrData[rightChild])) {
        fnSwap(parentIdx, rightChild)
        numBalanced = RIGHT_CHILD
      } else if (arrData[parentIdx] < arrData[leftChild]) {
        fnSwap(parentIdx, leftChild)
        numBalanced = LEFT_CHILD
      }
    }
    return numBalanced
  }

  function fnBalanceHeap () {
    let idx
    let numBalanced = NEED_CHANGE
    while (numBalanced) {
      numBalanced = NO_CHANGE
      idx = numTail
      while (idx + 1) numBalanced += fnBalanceTriad(idx--) //  Balance triads in L->R, T->B (not path) order
    }
  }

  function fnRemoveHead () {
    fnSwap(0, numTail--)  // Sorted
    let numBalanced = NO_CHANGE
    let idx = 0 // Reference to first element
    do {
      numBalanced = fnBalanceTriad(idx)
      idx += (idx + numBalanced)  //  Follow the change path
    } while (numBalanced) // We can stop when we encounter NO_CHANGE
  }

  console.log('Initial:', arrData.join(), `[Count:${numTail}]`)
  fnBalanceHeap() // Perform an inital balancing of the array using the heap
  while (numTail) {
    fnRemoveHead()  // Poor name - Add highest value (head) to tail
    console.log('Cycle:', arrData.join())
  }
  console.log('Final:', arrData.join())
  return arrData
}
