package mars.wordpal.interfaces;

import mars.wordpal.infrastructure.WordCollectionsInMemory;
import mars.wordpal.infrastructure.WordpalDatabaseHelper;
import android.app.Application;

public class ApplicationStartup extends Application {
  private WordpalDatabaseHelper wordpalDatabaseHelper;

  @Override
  public void onCreate() {
    super.onCreate();

    wordpalDatabaseHelper = new WordpalDatabaseHelper(getApplicationContext());
    // Let's give lesson 1 to 26 free to everyone.
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson1().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson2().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson3().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson4().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson5().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson6().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson7().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson8().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson9().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson10().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson11().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson12().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson13().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson14().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson15().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson16().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson17().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson18().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson19().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson20().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson21().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson22().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson23().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson24().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson25().name());
    wordpalDatabaseHelper.doCheckLessonXInserted(WordCollectionsInMemory.wordTrainerLesson26().name());
  }

}