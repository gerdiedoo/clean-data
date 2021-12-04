// This implementation is not consistent with the stack implemented using linked-list API.

class Stack {
  constructor() {
    this.stackData = [];
  }

  peek() {
    return this.stackData[this.stackData.length - 1];
  }

  push(value) {
    this.stackData.push(value);
  }

  pop() {
    return this.stackData.pop();
  }
}

// tests

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
