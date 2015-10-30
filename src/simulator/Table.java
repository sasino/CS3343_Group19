package simulator;

import java.util.ArrayList;

//enum Tablesize{
//  TWO(2),
//  FOUR(4),
//  EIGHT(8);
//  
//  private int size;
//  
//  private Tablesize(int size)
//  {
//    this.size=size;
//  }
//}

public class Table
{
  private int size;
  private int occupied;
  private ArrayList<CustomerGroup> allCustomers;
  
  public Table(int size) throws Exception
  {
    if(size==2 || size==4 || size==8)
    {
      this.size=size;
      allCustomers = new ArrayList<CustomerGroup>();
      occupied=0;
    }
    else
    {
      throw new Exception("Invalid table size");
    }
  }
  
  public int add(CustomerGroup customer)
  {
    if(customer.getSize()+occupied > size)
    {
    return 1;
    }
    else
    {
      occupied+=customer.getSize();
      allCustomers.add(customer);
      return 0;
    }
  }
  
  public int remove(CustomerGroup customer)
  {
    if(allCustomers.contains(customer))
    {
      if(customer.getSize() > occupied)
      {
      return 1;
      }
      else
      {
        occupied-=customer.getSize();
        allCustomers.remove(customer);
        return 0;
      }
     }
    return 1;
  }
  
  public int getSize()
  {
    return size;
  }
  
  public int getOccupied()
  {
    return occupied;
  }
  
  public int getRemaining()
  {
    return size - occupied;
  }
  
  public int getAvailable()
  {
    int avail = 0;
    for(CustomerGroup customer : allCustomers)
    {
      if(customer.getState() instanceof StateWaitingFood)
      {
        avail+=customer.getSize();
      }
    }
    return avail;
  }
  
  public ArrayList<CustomerGroup> getWaitingCustomers()
  {
    ArrayList<CustomerGroup> availCustomers = new ArrayList<CustomerGroup>();
    for(CustomerGroup customer : allCustomers)
    {
      if(customer.getState() instanceof StateWaitingFood)
      {
        availCustomers.add(customer);
      }
    }
    return availCustomers;
  }
  
  public void clearTable()
  {
    allCustomers.clear();
  }
}
