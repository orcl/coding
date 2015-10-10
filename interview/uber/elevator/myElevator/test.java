import java.util.*;

class elevatorCabin {

  public final int size = 30;
  public int currentFloor = 0;
  public int direction = 1;  //1 means up, 0 means down
  public PriorityQueue<Integer> upRequests;
  public PriorityQueue<Integer> downRequests;

  public elevatorCabin() {
    upRequests   = new PriorityQueue<Integer>();
    downRequests = new PriorityQueue<Integer>(size, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        if (i1 == i2) {
          return 0;
        }
        return i1 < i2 ? 1:-1;
      }
    });
  }

  public void addRequest(Integer floor, int direction) {
    if (direction == 1 ) {
      //going up
      this.upRequests.add(floor);
    }else if (direction == 0) {
      //going down
      this.downRequests.add(floor);
    }
  }

  public void gotoNext() {
    int nextFloor = this.currentFloor;
    switch(this.direction) {
      case 1:
        Integer tmp = upRequests.poll();
        if (tmp != null) {
          nextFloor = tmp;
          System.out.println("going to floor number : " + nextFloor);
          currentFloor = nextFloor;
        }else {
          //change direction
          System.out.println("changing the direction");
          direction = 0;
        }
        break;
      case 0:
        Integer tmp1 = downRequests.poll();
        if (tmp1 != null) {
          nextFloor = tmp1;
          System.out.println("going to floor number : " + nextFloor);
          currentFloor = nextFloor;
        }else if (upRequests.size() > 0) {
          //change direction
          System.out.println("changing the direction");
          direction = 1;
        }else {
          //go to lobby floor
          this.gotoLobby();
        }
        break;
    }//end switch 
    try {
      Thread.sleep(2000);
      System.out.println("moving .......");
    }catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void gotoLobby() {
    if (upRequests.size() == 0 && downRequests.size() == 0) {
      System.out.println("go to lobby.");
      currentFloor = 0;
    }else {
      System.out.println("can't go to lobby, there's still some request.");
    }
  }

}//end class 


class elevatorEngine extends Thread {

  private elevatorCabin cabin = new elevatorCabin();
  private volatile boolean stopFlag = false;
  
  public void startEngine() {
    stopFlag = false;
    this.start();
  }
  
  public void stopEngine() {
    stopFlag = true;
  }

  public void run() {
  
    while (true) {
      if (stopFlag) {
        if (this.cabin.upRequests.isEmpty() && this.cabin.downRequests.isEmpty()) {
          break;
        }
      }
      try {
        Thread.sleep(1000);
      }catch(Exception e) {
        e.printStackTrace();
      }
      this.cabin.gotoNext();
   }
  }//thread run


  public void pressButton(int floor, int direction) {
    String tmp = (direction == 1)?"up. ":"down. ";
    System.out.println("Pressed " + floor + " , " + "going " + tmp);
    if (direction == 1) {
      this.cabin.upRequests.add(floor);
    }else if (direction == 0) {
      this.cabin.downRequests.add(floor);
    }
  }
}//end class elevatorEngine


public class test {

  public static void main(String[] args) {
  
    elevatorEngine engine = new elevatorEngine();
    engine.startEngine();
    engine.pressButton(1,1);
    engine.pressButton(3,1);
    engine.pressButton(5,1);
    engine.pressButton(4,0);
    engine.pressButton(2,0);
    engine.pressButton(7,1);
    try {
      engine.join();
    }catch(InterruptedException e) {
      e.printStackTrace();
    }
  
  }//end main

}






