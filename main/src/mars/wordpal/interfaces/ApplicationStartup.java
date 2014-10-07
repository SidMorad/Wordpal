package mars.wordpal.interfaces;

import mars.wordpal.infrastructure.WordpalDatabaseHelper;
import android.app.Application;

public class ApplicationStartup extends Application {
  private WordpalDatabaseHelper wordpalDatabaseHelper;

  @Override
  public void onCreate() {
    super.onCreate();

    wordpalDatabaseHelper = new WordpalDatabaseHelper(getApplicationContext());
    wordpalDatabaseHelper.doCheckLessonOneInserted();
  }

}