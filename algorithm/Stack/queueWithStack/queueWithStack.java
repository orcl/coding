public class queueWithStack {

  Stack<Integer> inbox  = new Stack<Integer>();
  Stack<Integer> outbox = new Stack<Integer>();

  //push element x to the back of queue
  public void push(int x) {
    inbox.push(x);
  }

  //removes the element from in front of queue
  public void pop() {
    if (outbox.isEmpty()) {
      while(!inbox.isEmpty()){
        outbox.push(inbox.pop());
      }
    }
    outbox.pop();
  }

  //get the front element.
  public int peek() {
    if (outbox.isEmpty()){
      while(!inbox.isEmpty()){
        outbox.push(inbox.pop());
      }
    }
    outbox.peek();
  }

  //return whether the queue is empty.
  public boolean empty() {
    return inbox.isEmpty() && outbox.isEmpty();
  }

}
