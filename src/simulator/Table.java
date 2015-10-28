package simulator;

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
  
  public Table(int size) throws Exception
  {
    if(size==2 || size==4 || size==8)
    {
      this.size=size;
      occupied=0;
    }
    else
    {
      throw new Exception("Invalid table size");
    }
  }
  
  public int add(int n)
  {
    if(n+occupied > size)
    {
    return 1;
    }
    else
    {
      occupied+=n;
      return 0;
    }
  }
  
  public int remove(int n)
  {
    if(n > occupied)
    {
    return 1;
    }
    else
    {
      occupied-=n;
      return 0;
    }
  }
  
  public int getSize()
  {
    return size;
  }
  
  public int getOccupied()
  {
    return occupied;
  }
}
