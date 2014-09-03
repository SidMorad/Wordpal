package organic.fact;

import static organic.fact.FactRunner.precisionOne;
import junit.framework.TestCase;

public class FactTest extends TestCase {

  public void testPrecisionOne() {
    assertEquals("0.0", precisionOne("0.0"));
    assertEquals("0.0", precisionOne("0.00"));
    assertEquals("0.0", precisionOne("0.000"));
    assertEquals("10.0", precisionOne("10.0"));
    assertEquals("10.0", precisionOne("10.00"));
    assertEquals("10.0", precisionOne("10.001"));
  }

}