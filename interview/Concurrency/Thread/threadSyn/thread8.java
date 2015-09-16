public class thread10 {

  public static void main(String[] args) {
    compute t1 = new compute('a');
    compute t2 = new compute('b');
    compute t3 = new compute('c');

    t1.start();
    t2.start();
    t3.start();

  }//end main

}//end class thread10


class compute extends Thread {

  char ch;
  static Object obj = new Object();
  compute(char ch) {
    this.ch = ch;
  }

  public void print(char ch) {
    for (int i = 0; i < 10; i++) {
      System.out.println(ch);
    }
  }

  public void run() {
    synchronized(obj) {
      for (int i = 1; i< 10; i++) {
        print(ch);
        System.out.println();
      }
    }
  }

}//end compute


//the static object becomes the lock,
//the thread which acquired the lock can execute the synchronized block.
//






