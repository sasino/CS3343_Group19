package simulator;

import java.util.Date;
import java.util.PriorityQueue;

class CustomerQueue {

   // Formula to calculate priority
   //  first condition: waited time / 60s
   //   optional: level

  PriorityQueue<Ticket> customerQueue;

  public CustomerQueue() {
    customerQueue = new PriorityQueue<Ticket>();
  }
  
  public int queueSize() {
    return this.customerQueue.size();
  }

  public void updatePriority(Date currentTime) {
    for (Ticket e:this.customerQueue) {
      double additionalPriority = (e.getTime() - currentTime.getTime()) * 1000 / 60;
      e.updatePriority(additionalPriority);
    }
  }

}