// Represents the stack data structure impleted using an array.
class Stack {
  constructor() {
    /* Properties like top, bottom and length can be accessed using the in-built array methods, 
      they are just here to keep the stack API consistent with the linked-list based implementation.*/
    this.stackData = [];
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
    this.stackData.push(value);
    this.length++;
    if (this.length === 1) {
      this.bottom = this.stackData[0];
    }
    this.top = this.stackData[this.length - 1];
  }

  // Removes a node from the top of a stack and returns it.
  pop(value) {
    if (!this.length) {
      return null;
    }
    const deletedValue = this.stackData.pop();
    this.length--;
    if (!this.length) {
      this.bottom = null;
      this.top = null;
    }
    return deletedValue;
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
