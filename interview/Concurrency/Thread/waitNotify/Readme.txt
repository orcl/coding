1. synchronized keyword is used for exclusive accessing.
2. to make a method synchronized, simply add the synchronized keyword to its declaration.
   then no two invocation of synchronized methods on the same object can interleave with each other.
3. synchronized statements must specify the object that provides the intrinsic lock.
   when synchronized(this) is used, you have to avoid to synchronizing invocation of other object's methods.

4. wait() method tells the calling thread to give up the monitor and go to sleep until some other thread enters the same monitor
and calls notify().

5. notify() wakes up the first thread that called wait() on the same object.

below is an example of notify() and wait()

public class ThreadA {
  public static void main(String[] args) {
    ThreadB b = new ThreadB();
    b.start();

    synchronized(b) {
      try {
        System.out.println("waiting for b to complete...");
        b.wait();
      }catch(InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("total is: " + b.total);
    }
  }
}

public ThreadB extends Thread {
  int total;
  @Override
  public void run() {
    synchronized(this) {
      for (int i = 0; i< 100; i++) {
        total += i;
      }
      notify();
    }
  }
}

//in the example above, an object b, is synchronized. b completes the calculation before main thread outputs its total value.


another more complex example of wait and notify.

class Producer extends Thread {
  
  static final int MAXQUEUE = 5;
  private Vector messages = new Vector();

  @Override
  public void run() {
    try {
      while (true) {
        putMessage();
      }
    }catch(InterruptedException e) {
    }
  }

  private synchronized void putMessage() throws InterruptedException {
    while (message.size() == MAXQUEUE) {
      wait();
    }
    message.addElement(new java.util.Date().toString());
    System.out.println("put message");
    notify();
  }

  //called by consumer
  public synchronized String getMessage() throws InterruptedException {
    notify();
    while (message.size() == 0) {
      wait();  //by executing wait() from a synchronized block, a thread gives up its lock and goes on to sleep.
    }
    String message = (String) messages.firstElement();
    messages.removeElement(message);
    return message;
  }
}


class Consumer extends Thread {
  Producer producer;

  Consumer(Producer p) {
    producer = p;
  }

  @Override
  public void run() {
    try {
      while (true) {
        String message = producer.getMessage();
        System.out.println("got message: " + message);
      }
    }catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Producer producer = new Producer();
    producer.start();
    new Consumer(producer).start();
  }
}





