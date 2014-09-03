package organic.fact;

import junit.framework.TestFailure;
import junit.framework.TestResult;

public class FactRunner {

  private static final double NANOSECONDS = 1000000000.0;

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    long startN = System.nanoTime();

    TestResult result = new TestResult();
    new FactSuite().run(result);
    printResult(start, startN, result);
  }

  private static void printResult(long start, long startN, TestResult result) {
    String elapsedTime = diffSecondsRounded(startN) + "";
    if (result.wasSuccessful()) {
      System.out.println(
        String.format(
          "%s%n%s%n" +
          "%s Tests OK%n" +
          "%s Mtook%n",
          readableTimeMillis(start),
          readableTimeMillis(System.currentTimeMillis()),
          result.runCount(),
          precisionOne(elapsedTime)
        )
      );
    } else {
      System.out.println(
        String.format(
          "%s%n%s%n" +
          "%s Tests, %s Errors, %s Failures.%n" +
          "%s Mtook%n",
          readableTimeMillis(start),
          readableTimeMillis(System.currentTimeMillis()),
          result.runCount(), result.errorCount(), result.failureCount(),
          precisionOne(elapsedTime)
        )
      );
      printCause(result);
    }
  }

  private static void printCause(TestResult result) {
    if (result.errorCount() > 0) {
      TestFailure firstError = result.errors().nextElement();
      System.out.println(firstError.exceptionMessage());
      System.out.println(firstError.trace());
    }
    if (result.failureCount() > 0) {
      TestFailure firstFailure = result.failures().nextElement();
      System.out.println(firstFailure.exceptionMessage());
      System.out.println(firstFailure.trace());
    }
  }

  private static double diffSecondsRounded(long startN) {
    long elapsedTime = System.nanoTime() - startN;
    double elpedTime = (double) elapsedTime / NANOSECONDS;
    return Math.round(elpedTime * 100.0) / 100.0;
  }

  protected static String precisionOne(String elapsedTime) {
    int dotIndex = elapsedTime.indexOf(".");
    if (elapsedTime.length() - dotIndex > 2) {
      return elapsedTime.substring(0, dotIndex + 2);
    }
    return elapsedTime;
  }

  protected static String readableTimeMillis(long timeMillis) {
    String tstring = timeMillis + "";
    return "--------" + tstring.substring(8, 11);
  }

}