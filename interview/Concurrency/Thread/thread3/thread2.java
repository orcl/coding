public class thread2 {

  public static void main(String[] args) {
  
    compute t = new compute();
    compute1 t1 = new compute1();

    t.setPriority(10);
    t1.setPriority(1);
    t.start();
    t1.start();
    try {
      Thread.sleep(1000); // wait for 5 seconds
    }catch(InterruptedException e) {
    
    }
  }//end main method

}//end class thread2


class compute extends Thread {

  int i = 0;
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
  }
}

class compute1 extends Thread {
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("this number is: " + i);
    }
  }
}





