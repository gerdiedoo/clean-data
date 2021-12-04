// Represents a node of a queue.
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

// Represents the queue data structure impleted using a linked-list.
class Queue {
  constructor() {
    this.first = null;
    this.last = null;
    this.length = 0;
  }

  // // Returns the node at the front of the queue.
  peek() {
    return this.first;
  }

  // Add a node with the provided value to the last of the queue.
  enqueue(value) {
    const newNode = new Node(value);
    if (!this.length) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }
    this.length++;
  }

  // Removes a node from the front of a queue and returns it.
  dequeue() {
    if (!this.length) {
      return null;
    }

    if (this.first === this.last) {
      this.last = null;
    }

    const removedNode = this.first;
    this.first = this.first.next;
    this.length--;
    return removedNode;
  }
}

// tests

const myQueue = new Queue();
console.log(myQueue.peek());
myQueue.enqueue('Michael');
console.log(myQueue.peek());
myQueue.enqueue('Dwight');
myQueue.enqueue('Jim');
console.log(JSON.stringify(myQueue));
console.log(myQueue.dequeue());
console.log(JSON.stringify(myQueue));
console.log(myQueue.dequeue());
console.log(myQueue.dequeue());
console.log(JSON.stringify(myQueue));
