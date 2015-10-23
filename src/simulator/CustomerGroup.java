package simulator;

public class CustomerGroup {
  private int id;
  private int number;
  private CustomerStats state;
  
  /**
   * Constructor.
   */
  public CustomerGroup(int aaId, int aaNumber, CustomerStats aaState) {
    this.id = aaId;
    this.number = aaNumber;
    this.state = aaState;
  }
  
  public int getSize() {
    return this.number;
  }
  
  public int getId() {
    return this.id;
  }
  
  public CustomerStats  getState() {
    return this.state;
  }
  
  
}