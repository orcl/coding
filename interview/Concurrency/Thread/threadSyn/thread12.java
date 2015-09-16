public class thread12 {

  public static void main(String[] args) {
  
    compute t = new compute();
    new Thread(t).start();
    new Thread(t).start();
    new Thread(t).start();

  }//end main function
}//end class thread12


class compute extends Thread {

  int i = 10;
  static Object obj = new Object();
  synchronized void print() {
    System.out.println(Thread.currentThread().getName()+":"+i);
    i--;
  }

  public void run() {
    while (i>0) {
      print();
      try {
        sleep(1000);
      }catch(Exception e) {
      }
    }
  }

}








