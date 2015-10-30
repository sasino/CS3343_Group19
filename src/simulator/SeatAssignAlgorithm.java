package simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SeatAssignAlgorithm {
  public static Table allowSeatChange(CustomerGroup customer, ArrayList<Table> allTables)
  {
    Collections.sort(allTables, new TableAvailComparator());
    
    for(Table t : allTables)
    {
      if(customer.getSize() <= t.getAvailable())
        return t;
    }
    return null;
  }
  
  public static Table noSeatChange(CustomerGroup customer,ArrayList<Table> allTables)
  {
    Collections.sort(allTables, new TableRemainingComparator());
    
    for(Table t : allTables)
    {
      if(customer.getSize() <= t.getRemaining())
        return t;
    }
    return null;
  }
}


class TableAvailComparator implements Comparator<Table>
{

  @Override
  public int compare(Table o1, Table o2) 
  {
    return o1.getAvailable() < o2.getAvailable() ? -1 : o1.getAvailable() == o2.getAvailable() ? 0 : 1;
  }
}

class TableRemainingComparator implements Comparator<Table>
{

  @Override
  public int compare(Table o1, Table o2) 
  {
    return o1.getRemaining() < o2.getRemaining() ? -1 : o1.getRemaining() == o2.getRemaining() ? 0 : 1;
  }
}
