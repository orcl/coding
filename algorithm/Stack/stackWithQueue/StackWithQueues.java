

public class StackWithQueues {

  LinkedList<Integer> queue1;
  LinkedList<Integer> queue2;

  public MyStack() {
    queue1 = new LinkedList<Integer>();
    queue2 = new LinkedList<Integer>();
  }

  //Push elment x onto stack
  public void push(int x) {
    if (queue1.isEmpty()) {
      queue2.add(x);
    }else {
      queue1.add(x);
    }
  }

  //Removes the element on top of the stack
  public void pop() {
    int size = 0;
    if (queue1.isEmpty()) {
      size = queue2.size();
      int tmp = 0;
      while (tmp < size -1 ) {
        queue1.add(queue2.removeFirst());
        tmp++;
      }
      queue2.removeFirst();
    }else {
      size = queue1.size();
      int tmp = 0;
      while (tmp < size - 1) {
        queue2.add(queue1.removeFirst());
        tmp++;
      }
      queue1.removeFirst();
    }
  }

  //get the top element
  public int top() {
    int result = 0;
    int size = 0;
    if (queue1.isEmpty()) {
      size = queue2.size();
      int tmp = 0;
      while (tmp < size-1) {
        queue1.add(queue2.removeFirst());
        tmp++
      }
      result = queue2.removeFirst();
      queue1.add(result);
      return result;
    }else {
      size = queue1.size();
      int tmp = 0;
      while (tmp < size-1) {
        queue2.add(queue1.removeFirst());
        tmp++;
      }
      result = queue1.removeFirst();
      queue2.add(result);
      return result;
    }
  }

  //return whether the stack is empty
  public boolean empty() {
    return queue1.isEmpty() && queue2.isEmpty();
  }

}//end class StackWithQueues





