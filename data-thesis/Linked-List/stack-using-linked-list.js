// Represents a node of a stack.
class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

// Represents the stack data structure impleted using a linked-list.
class Stack {
  constructor() {
    this.top = null;
    this.bottom = null;
    this.length = 0;
  }

  // Returns the node at the top of the stack.
  peek() {
    return this.top;
  }

  // Add a node with the provided value to the top of the stack.
  push(value) {
    const newNode = new Node(value);

    if (!this.bottom) {
      this.bottom = newNode;
    }
    newNode.next = this.top;
    this.top = newNode;
    this.length++;
  }

  // Removes a node from the top of a stack and returns it.
  pop() {
    if (!this.top) {
      return null;
    }
    if (!this.top.next) {
      this.bottom = null;
    }
    const removedNode = this.top;
    this.top = this.top.next;
    this.length--;
    return removedNode;
  }
}

// test
const myStack = new Stack();
console.log(myStack.peek());
myStack.push(10);
myStack.push(20);
myStack.push(30);
console.log(JSON.stringify(myStack));
console.log(myStack.peek());
console.log(myStack.pop());
console.log(myStack.pop());
console.log(myStack.pop());
console.log(JSON.stringify(myStack));
