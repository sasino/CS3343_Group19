package simulator;

import java.util.ArrayList;

public class EventScheduler {
  private ArrayList<Events> eventQueue;
  
  public EventScheduler() {
    this.eventQueue = new ArrayList<Events>();
  }
  
  public void addEvent(Events aaEvent) {
    eventQueue.add(aaEvent);
  }
  
  /** 
   * Update event info and replace it with one in queue.
   * 
   */
  public void updateEvent(Events oldEvent, Events newEvent) {
    @SuppressWarnings("unused")
    Events targetEvent;
    for (int x = 0; x < eventQueue.size(); x++) {
      if (eventQueue.get(x) == oldEvent) {
        targetEvent = eventQueue.get(x);
      }
    }
    targetEvent = newEvent;
  }
}