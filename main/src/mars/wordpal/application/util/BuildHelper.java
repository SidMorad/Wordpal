package mars.wordpal.application.util;

import android.os.Build;

public class BuildHelper {
  
  public static boolean api8orHigher() {
    try {
      if (Build.VERSION.RELEASE.startsWith("1") ||
          Build.VERSION.RELEASE.startsWith("2.0") ||
          Build.VERSION.RELEASE.startsWith("2.1")) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean api9orHigher() {
    try {
      if (Build.VERSION.RELEASE.startsWith("1") ||
          Build.VERSION.RELEASE.startsWith("2.0") ||
          Build.VERSION.RELEASE.startsWith("2.1")) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  public static boolean api11orHigher() {
    try {
      if (Build.VERSION.RELEASE.startsWith("1") ||
          Build.VERSION.RELEASE.startsWith("2")) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean api13orHigher() {
    try {
      if (Build.VERSION.RELEASE.startsWith("1") ||
          Build.VERSION.RELEASE.startsWith("2") ||
          Build.VERSION.RELEASE.startsWith("3.0") ||
          Build.VERSION.RELEASE.startsWith("3.1")) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}