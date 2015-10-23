package simulator;

import java.util.Date;

class Ticket implements Comparable<Ticket> {
  
  private CustomerGroup gp;
  private Date time;
  private double priority;

  Ticket(CustomerGroup defaultGroup, Date startTime) {
    gp = defaultGroup;
    time = startTime;
    priority = 1;
  }
  
  public CustomerGroup getCustomer() {
    return this.gp;
  }
  
  public long getTime() {
    return this.time.getTime();
  }
  
  public double getPriority() {
    return this.priority;
  }
  
  public void updatePriority(double newPriority) {
    this.priority += newPriority;
  }

  @Override
  public int compareTo(Ticket otherTicket) {
    if (this.priority > otherTicket.getPriority()) {
      return 1;
    } else if (this.priority < otherTicket.getPriority()) {
      return -1;
    }
    return 0;
  }
}