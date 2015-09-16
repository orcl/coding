public class threadtest {

  public static void main(String[] args) {
    
    compute c   = new compute();
    compute1 c1 = new compute1();

    Thread t  = new Thread(c);
    Thread t1 = new Thread(c1);
    t.start();
    t1.start();

  }//end main 

}//end class


class compute implements Runnable {

  int i = 0;
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
  }
}//end class compute


class compute1 implements Runnable {

  public void run() {
  
    for (int i = 0; i < 10; i++) {
      System.out.println("this number is: " + i);
    }
  }//end run()

}//end class compute1




