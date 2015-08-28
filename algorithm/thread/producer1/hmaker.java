public class hmaker extends Thread {

  public void make() {
    synchronized(ham.box);
    try {
      ham.box.notify();
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void run() {
    while (ham.production<ham.totalmaterial) {
      if (ham.production > 0) {
        System.out.println("chef A : number of hamburger, " + ham.production-ham.sales);
      }
      try {
        sleep(3000);
      }catch(Exception e) {
        make();
      }
    }
  }
}



class hassistant extends Thread {

  public void sell() {
    if (ham.production == 0) {
      system.out.println("customers, no burgers no more.");
    }
    try {
      ham.box.wait();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    ham.sales++;
    System.out.println("customer, hello, hamburger is here.");
  }

  public void run() {
    while (ham.sales < ham.production) {
      try {
        sleep(1000);
      }catch(Exception e) {
      }
      sell();
    }
  }
}


public class thread13 {
  public static void main(String[] args) {
    hmaker maker = new hmaker();
    hassistant assistant = new hassistant();
    maker.start();
    assistant.start();
  }
}

