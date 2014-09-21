package organic.fact;

import mars.wordpal.domain.WordListTest;
import junit.framework.TestSuite;

public class FactSuite extends TestSuite {

  public FactSuite() {
    addTestSuite(FactTest.class);
    addTestSuite(WordListTest.class);
  }

}