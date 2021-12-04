/* Explanation
STRUCTURE BinaryTree
    BinaryTree:LeftSubTree
    Object:Node
    BinaryTree:RightSubTree

PROCEDURE Insert(BinaryTree:searchTree, Object:item)
    IF searchTree.Node IS NULL THEN
        SET searchTree.Node TO item
    ELSE
        IF item IS LESS THAN searchTree.Node THEN
            Insert(searchTree.LeftSubTree, item)
        ELSE
            Insert(searchTree.RightSubTree, item)

PROCEDURE InOrder(BinaryTree:searchTree)
    IF searchTree.Node IS NULL THEN
        EXIT PROCEDURE
    ELSE
        InOrder(searchTree.LeftSubTree)
        EMIT searchTree.Node
        InOrder(searchTree.RightSubTree)

PROCEDURE TreeSort(Array:items)
    BinaryTree:searchTree

    FOR EACH individualItem IN items
        Insert(searchTree, individualItem)

    InOrder(searchTree)
*/

function treeSort (arrData) {
  'use strict'
  const BTREE_LEFT = 'left'
  const BTREE_NODE = 'parent'
  const BTREE_RIGHT = 'right'

  function addNode (parentValue) {
    return {left: null, parent: parentValue, right: null}
  }

  function insertNode (data, node) {
    if (node === null) {
      return addNode(data)
    } else {
      node[(data < node[BTREE_NODE]) ? BTREE_LEFT : BTREE_RIGHT] =
        insertNode(data, node[(data < node[BTREE_NODE]) ? BTREE_LEFT : BTREE_RIGHT])
      return node
    }
  }

  function inOrder (arrResults, node) {
    if (node !== null) {
      arrResults.concat(inOrder(arrResults, node[BTREE_LEFT]))
      arrResults.push(node[BTREE_NODE])
      arrResults.concat(inOrder(arrResults, node[BTREE_RIGHT]))
    }
    return arrResults
  }

  function _treeSort (arrItems) {
    let binaryTree = null
    let arrSorted = []
    arrData.forEach(dataItem => {
      binaryTree = insertNode(dataItem, binaryTree)
      console.log(dataItem, binaryTree)
    })
    arrSorted = inOrder(arrSorted, binaryTree)
    console.log('Final:', arrSorted.join(), `[Count:${arrSorted.length}]`)
    return arrSorted
  }

  console.log('Initial:', arrData.join(), `[Count:${arrData.length}]`)
  return _treeSort(arrData)
}
