public class MinStack {

  Stack<Integer> s1 = new Stack<Integer>();
  Stack<Integer> s2 = new Stack<Integer>();

  public void push(int x) {
    s1.push(x);
    if (x <= min) {
      s2.push(x);
      min = x;
    }
  }

  public void pop() {
    int tmp = s1.pop();
    if (tmp == min) {
      s2.pop();
      if (!s2.isEmpty())
        min = s2.peek();
      else
        min = Integer.MAX_VALUE;
    }
  }

  public int top() {
    return s1.peek();
  }

}//end class MinStack
