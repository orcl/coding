import java.util.TreeSet;

public class ElevatorCabin {

  public int currentFloor = 0;
  public UpDownEnum direction = UpDownEnum.UP;
  public TreeSet<Integer> callingFloorList = new TreeSet<Integer>();

  public void add(Integer floor) {
    callingFloorList.add(floor);
  }

  public Integer gotoNext() {
    Integer nextFloor = currentFloor;
    switch(direction) {
      case UP:
        for (Integer floor : callingFloorList) {
          nextFloor = floor;
          direction = UpDownEnum.UP;
          break;
        }
        if (nextFloor = currentFloor) {
          for (Integer floor : callingFloorList.descendingSet()) {
            if (floor < nextFloor) {
              nextFloor = floor;
              direction = UpDownEnum.DOWN;
              break;
            }
          }
        }
        break;
      case DOWN:
        for (Integer floor : callingFloorList.descendingSet()) {
          if (floor < nextFloor) {
            nextFloor = floor;
            direction = UpDownEnum.DOWN;
            break;
          }
        }

        if (nextFloor == currentFloor) {
          for (Integer floor : callingFloorList) {
            if (floor > nextFloor) {
              nextFloor = floor;
              direction = UpDownEnum.UP;
              break;
            }
          }
        }
    
        callingFloorList.remove(nextFloor);
        currentFloor = nextFloor;
        return nextFloor;
    }//end switch
  }



}//end class


public class ElevatorEngine extends Thread {
  
  private ElevatorCabin cabin = new ElevatorCabin();
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
        if (cabin.callingFloorList.isEmpty()) {
          break;
        }
      }
      Integer next = cabin.gotoNext();
      System.out.println("Next floor is :" +next);

      try {
        Thread.sleep(1000);
      }catch( InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void pressButton(int floor) {
    System.out.println("Pressed " + floor);
    cabin.add(floor);
  }

}


public class ElevatorEngineDriver {
  public static void main(String[] args) {
    ElevatorEngine engine = new ElevatorEngine();
    engine.startEngine();

    engine.pressButton(1);
    sleep();
    engine.pressButton(5);
    engine.pressButton(6);
    engine.pressButton(1);
    engine.pressButton(4);
    sleep();
    sleep();
    engine.pressButton(2);
    engine.pressButton(9);
    engine.pressButton(1);
    sleep();
    engine.stopEngine();
    try {
      engine.join();
    }catch(InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void sleep() {
    try {
      Thread.sleep(1500);
    }catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}




