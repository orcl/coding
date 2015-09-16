class ham {
  static Object box = new Object();
  static int totalmaterial = 10;
  static int sales = 0;
  static int production = 5;
}//end ham

class hmaker extends Thread {

  public void make() {
    synchronized(ham.box) {
      try {
        ham.box.notify();
      }catch(Exception e) {
      }
    }
  }

  public void run() {
    while (ham.production < ham.totalmaterial) {
    
      if (ham.production >0) {
        System.out.println("chef " + getName() + " : " + " hamburger coming.");
      }
      try {
        sleep(3000);
      }catch(Exception e) {
        e.printStackTrace();
      }
    }//end while

    make();
  }//end run()

}




class hassistant extends Thread {
  
  public void sell() {
  
    if (ham.production == 0) {
      System.out.println("sales: customer please wait.");
    }

    try {
      ham.box.wait(); //this waits for the notify().
    }catch(Exception e) {
    }

    ham.sales++;
  
    System.out.println("sales: hi customer, hamburger is coming.");
  }//end sell

  public void run() {
    while (ham.sales < ham.production) {
      try {
        sleep(1000);
      }catch(Exception e) {
        e.printStackTrace();
      }
      sell();
    }
  }
}


pubic class thread13 {

  public static void main(String[] args) {
 
    hmaker maker = new hmaker();
    hassistant assitant = new hassistant();
    maker.setName("jia");
    maker.start();
    assistant.start();
  }
}





