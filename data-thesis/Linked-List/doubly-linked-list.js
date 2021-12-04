// Represents a node of a doubly linked-list.
class Node {
  constructor(value) {
    this.value = value;
    this.previous = null;
    this.next = null;
  }
}

// Represents the data structure of a doubly linked-list of nodes.
class DoublyLinkedList {
  // Creates a linked list with one node with a provided value.
  // The head and the tail pointer pointing to that node.
  constructor(value) {
    this.head = new Node(value);
    this.tail = this.head;
    this.length = 1;
  }

  // A utility method that helps us view the contents of the linked-list.
  // Not a part of linked-list ADT.
  // JSON.stringify() can be used alternately to view the contents of the linked-list.
  printLinkedList() {
    let currentNode = this.head;
    const listElements = [];
    while (currentNode) {
      listElements.push(currentNode.value);
      currentNode = currentNode.next;
    }
    console.log(listElements);
  }

  // Adds a node to the end of the linked list with the value which is provided.
  // O(1) operation as we are keeping track of the tail pointer.
  append(value) {
    const newNode = new Node(value);
    newNode.previous = this.tail;
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
  }

  // Adds a node to the start of the linked list with the value which is provided.
  // O(1) operation as we are keeping track of the head pointer.
  prepend(value) {
    const newNode = new Node(value);
    newNode.next = this.head;
    this.head.previous = newNode;
    this.head = newNode;
    this.length++;
  }

  // Traverses the linked-list to the index specified and returns the node at that index,
  _traverseToIndex(index) {
    let counter = 0;
    let currentNode = this.head;
    while (counter != index) {
      currentNode = currentNode.next;
      counter++;
    }
    return currentNode;
  }

  // Adds a node with a value provided in the linked list at the index provided.
  // O(n) as finding the node after which the node should be inserted requires linked-list traversal.
  insert(index, value) {
    if (index === 0) {
      this.prepend(value);
      return;
    }

    if (index >= this.length) {
      this.append(value);
      return;
    }

    const newNode = new Node(value);
    const leader = this._traverseToIndex(index - 1);
    const follower = leader.next;
    leader.next = newNode;
    newNode.previous = leader;
    newNode.next = follower;
    follower.previous = newNode;
    this.length++;
  }

  // Removes a node from the linkded-list at the index provided.
  // O(n) as finding the node after which the node should be removed requires linked-list traversal.
  remove(index) {
    if (index === 0) {
      this.head = this.head.next;
      this.head.previous = null;
      this.length--;
      return;
    }

    if (index === this.length - 1) {
      this.tail = this.tail.previous;
      this.tail.next = null;
      this.length--;
      return;
    }

    const leader = this._traverseToIndex(index - 1);
    const unwantedNode = leader.next;
    const follower = unwantedNode.next;
    leader.next = follower;
    follower.previous = leader;
    this.length--;
  }
}

// test
const myLinkedList = new DoublyLinkedList(10);
myLinkedList.printLinkedList();
myLinkedList.append(20);
myLinkedList.append(30);
myLinkedList.prepend(1);
myLinkedList.printLinkedList();
myLinkedList.insert(2, 99);
myLinkedList.insert(2, 69);
myLinkedList.insert(0, 420);
myLinkedList.insert(20, 666);
myLinkedList.printLinkedList();
myLinkedList.remove(0);
myLinkedList.remove(2);
myLinkedList.remove(5);
myLinkedList.printLinkedList();
