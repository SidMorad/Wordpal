package mars.wordpal.application.comparator;

import java.util.ArrayList;

import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.WordpalDatabaseHelper;
import android.content.Context;
import android.content.SharedPreferences;

public class CollectionManager {
  private Context context;
  private WordpalDatabaseHelper wordpalDatabaseHelper;
  private SharedPreferences prefs;
  private long currentWordPosition;

  public CollectionManager(Context context) {
    this.context = context;
    this.wordpalDatabaseHelper = new WordpalDatabaseHelper(this.context);
    this.prefs = context.getSharedPreferences("wordpal", Context.MODE_PRIVATE);
    this.currentWordPosition = prefs.getLong("current_word_position", 0);
  }

  public long insertCollection(WordCollection wordCollection) {
    return wordpalDatabaseHelper.insertCollection(wordCollection);
  }

  public long currentWordPostion() {
    return currentWordPosition;
  }

  public ArrayList<WordCollection> userCollections() {
    return wordpalDatabaseHelper.userCollections();
  }

  public void markCollectionAsActive(WordCollection wordCollection) {
    wordpalDatabaseHelper.markCollectionAsActive(wordCollection);
  }

  public void markCollectionAsNotActive(WordCollection wordCollection) {
    wordpalDatabaseHelper.markCollectionAsNotActive(wordCollection);
  }

}