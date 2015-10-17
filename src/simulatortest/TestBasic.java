package simulatortest;

import junit.framework.TestCase;

public class TestBasic extends TestCase {
  /*
   *
   * @see junit.framework.TestCase#setUp()
   */

  @Override
  public void setUp() {}

  @Override
  public void tearDown() {}

  public void testFalse() {
    boolean result = false;
    assertEquals(result, false);
  }

  public void testTrue() {
    boolean result = true;
    assertEquals(result, true);
  }

}

