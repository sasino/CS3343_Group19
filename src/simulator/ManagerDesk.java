package simulator;

import java.util.ArrayList;

public class ManagerDesk {

  CustomerQueue queue;

  private ManagerDesk() {
    queue = new CustomerQueue();
  }
  
  private static class InstanceHolder {
    private static final ManagerDesk Instance = new ManagerDesk();
  }

  public ManagerDesk getInstance() {
    return InstanceHolder.Instance;
  }
  
  public void handleNewCustomerAction() {
    
  }
  
  public void customerJoinQueue() {
    
  }
  
  public void customerLeaveQueue() {
    
  }
  
  public boolean isAnyCustomer() {
    return this.queue.queueSize() > 0;
  }


  // if priority equal, the most fit group first

  public CustomerGroup nextCustomer(ArrayList<Integer> size) {
    return null;
  }

}