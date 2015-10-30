package simulator;

import java.util.ArrayList;
import java.util.Collections;

import org.joda.time.DateTime;


public class Manager {

  private EventScheduler es;
  private ArrayList<Table> allTables;

  public Manager() {
    //es = EventScheduler.getInstance();
  }

  /**
   * add event to event scheduler.
   * @param dt the time of the event occur.
   * @param cg the related customer group.
   */

  public void add( DateTime dt , CustomerGroup cg) {
    es = EventScheduler.getInstance();
    DateTime dtNew = dt.plusMinutes(5);
    System.out.println(dtNew.toString() +  " , "  + " , " + cg.toString());
    es.addEvents(new CustomerWaitFoodEvent(dtNew , cg));
  }
  
  public ArrayList<Table> getAllTables()
  {
    return allTables;
  }
  
  public int getRemainingSeats()
  {
    int totalRemain=0;
    for(Table t : allTables)
    {
      totalRemain+=t.getAvailable();
    }
    return totalRemain;
  }
  
  public void SeatAssign(CustomerGroup customer, Boolean changeAllowed)
  {
    if(changeAllowed)
     {
      Table t = SeatAssignAlgorithm.allowSeatChange(customer, allTables);
      if(t.getWaitingCustomers().size() > 0)
      {
        /*
         * foreach customer in t, reassign w/ change(True/False)
         * rearrange
         */
        for(CustomerGroup c : t.getWaitingCustomers())
        {
          SeatAssign(c, false);
        }
      }
        t.add(customer);
      
     }else{
       SeatAssignAlgorithm.noSeatChange(customer, allTables).add(customer);
     }
  }
  
  public void SeatSwitch()
  {
    
  }
  
  public void SeatRelease(CustomerGroup customer, Table t)
  {
    t.remove(customer);
  }
  
  public ArrayList<CustomerGroup> getAllCustomerGroups()
  {
    ArrayList<CustomerGroup> allCustomerGroups = new ArrayList<CustomerGroup>();
    
    for(Table t : allTables)
    {
      for(CustomerGroup c : t.getWaitingCustomers())
      {
        allCustomerGroups.add(c);
      }
    }
    
    return allCustomerGroups;
  }
}
