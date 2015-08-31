import java.util.*;

//an interface to be implemented by everyone interested in "hello" events.
interface EventListener {
  void postEvent();
}

class eventListener {
  
  private List<EventListener> listeners = new ArrayList<EventListener>();

  public void registerListener(EventListener toAdd) {
    listeners.add(toAdd);
  }

  public void postEvent() {
    System.out.println("Hello!");
    //notify everybody that may be interested.
    for (EventListener e1: listeners) {
      h1.postEvent();
    }
  }
}//end class eventListener

//some event class 
class Event implements EventListener {
  @Override
  public void postEvent() {
    System.out.println("hello there..");     
  }
}//end class Event




