package mars.wordpal.infrastructure;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WordpalDatabaseHelper extends SQLiteOpenHelper {
  private static final String DB_NAME = "wordpal4.sqlite";
  private static final int VERSION = 1;

  private static final String TABLE_COLLECTION = "collection";
  private static final String ID = "id";
  private static final String NAME = "name";
  private static final String ACTIVE = "active";

  private static final String TABLE_WORD = "word";
  private static final String CID = "cid";
  private static final String QUESTION = "question";
  private static final String ANSWERDE = "answerde";
  private static final String ANSWERFA = "answerfa";
  private static final String SCORE = "score";

  private static final String TAG = "WordpalDatabaseHelper";

  private static WordpalDatabaseHelper instance;

  public static synchronized WordpalDatabaseHelper getInstance(Context context) {
    if (instance == null) {
      instance = new WordpalDatabaseHelper(context);
    }
    return instance;
  }

  public WordpalDatabaseHelper(Context context) {
    super(context, DB_NAME, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table collection ("
        + "id integer primary key autoincrement, "
        + "name varchar(255) unique, "
        + ACTIVE + " boolean )");
    db.execSQL("create table word ("
        + "id integer primary key autoincrement, "
        + "question varchar(255), "
        + "answerde varchar(255), "
        + "answerfa varchar(255), "
        + "score integer, "
        + "cid integer references collection(id))");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
/*  db.rawQuery("DROP TABLE word", null);
    db.rawQuery("DROP TABLE collection", null);
    onCreate(db);*/
  }

  public long insertCollection(WordCollection wordCollection) {
    ContentValues cv = new ContentValues();
    cv.put(NAME, wordCollection.name());
    cv.put(ACTIVE, wordCollection.active());
    SQLiteDatabase sdb = getWritableDatabase();
    long cid = sdb.insert(TABLE_COLLECTION, null, cv);
    if (cid != -1) {
      for (Word word : wordCollection.wordz()) {
        ContentValues wcv = new ContentValues();
        wcv.put(QUESTION, word.getQuestion());
        wcv.put(ANSWERDE, word.getAnswerDe());
        wcv.put(ANSWERFA, word.getAnswerFa());
        wcv.put(SCORE, word.score());
        wcv.put(CID, cid);
        sdb.insert(TABLE_WORD, null, wcv);
      }
    }
    return cid;
  }

  public WordCollection selectCollection(String name) {
    Cursor cursor = getReadableDatabase().query(true, TABLE_COLLECTION,
      new String[] { ID, NAME, ACTIVE },
      NAME + "=?",
      new String[] { name },
      null, null, null, null);
    WordCollection collection = null;
    if (cursor.moveToFirst()) {
      collection = new WordCollection(
        cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
        cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
        null,
        (cursor.getInt(cursor.getColumnIndexOrThrow(ACTIVE)) == 0 ? false : true)
      );
    }
    if (cursor != null && !cursor.isClosed()) {
      cursor.close();
    }
    return collection;
  }

  public WordCollection currentCollection(int maxScore) {
    Cursor cursor = getReadableDatabase().rawQuery(
      "SELECT w.id, w.question, w.score, w.answerde, w.answerfa FROM word w INNER JOIN collection c ON w.cid=c.id where c." +ACTIVE+ "=1 AND w.score <" + maxScore, null);
    TreeSet<Word> wordz = new TreeSet<Word>(WordComparator.getInstance());
    if (cursor.moveToFirst()) {
      do {
        wordz.add(new Word(
          cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
          cursor.getString(cursor.getColumnIndexOrThrow(QUESTION)),
          cursor.getInt(cursor.getColumnIndexOrThrow(SCORE)),
          cursor.getString(cursor.getColumnIndexOrThrow(ANSWERDE)),
          cursor.getString(cursor.getColumnIndexOrThrow(ANSWERFA))
        ));
      } while (cursor.moveToNext());
    }
    if (cursor != null && !cursor.isClosed()) {
      cursor.close();
    }
    return new WordCollection(0, "", wordz, true);
  }

  public void doCheckLessonOneInserted() {
    Log.d(TAG, "Collection lesson one consideration.");
    if (selectCollection(WordCollectionsInMemory.wordTrainerLesson1().name())
        == null) {
      insertCollection(WordCollectionsInMemory.wordTrainerLesson1());
      Log.d(TAG, "Lesson one inserted.");
    }
  }

  public ArrayList<WordCollection> userCollections() {
    Cursor cursor = getReadableDatabase().query(true, TABLE_COLLECTION,
        new String[] { ID, NAME, ACTIVE },
        null, null, null, null, NAME, null);
      ArrayList<WordCollection> result = new ArrayList<WordCollection>();
      if (cursor.moveToFirst()) {
        do {
          result.add(new WordCollection(
              cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
              cursor.getString(cursor.getColumnIndexOrThrow(NAME)),
              null,
              (cursor.getInt(cursor.getColumnIndexOrThrow(ACTIVE)) == 0 ? false : true)
          ));
        } while (cursor.moveToNext());
      }
      if (cursor != null && !cursor.isClosed()) {
        cursor.close();
      }
      return result;
  }

  public void markCollectionAsActive(WordCollection wordCollection) {
    ContentValues cv = new ContentValues();
    cv.put(ACTIVE, 1);
    getWritableDatabase().update(TABLE_COLLECTION, cv , NAME + "=?", new String[] {wordCollection.name()});
  }

  public void markCollectionAsNotActive(WordCollection wordCollection) {
    ContentValues cv = new ContentValues();
    cv.put(ACTIVE, 0);
    getWritableDatabase().update(TABLE_COLLECTION, cv , NAME + "=?", new String[] {wordCollection.name()});
  }

  public void updateWordScorePlus(Word selectedWord, int maxScore) {
    Word current = selectWord(selectedWord.id());
    if (current.score() < maxScore) {
      current.addScore1Up();
      ContentValues cv = new ContentValues();
      cv.put(SCORE, current.score());
      getWritableDatabase().update(TABLE_WORD, cv, ID + "=?", new String[] { selectedWord.id() + ""});
    }
  }

  public void updateWordScoreMines(Word selectedWord) {
    Word current = selectWord(selectedWord.id());
    if (current.score() != 0) {
      current.minesScore1Down();
      ContentValues cv = new ContentValues();
      cv.put(SCORE, current.score());
      getWritableDatabase().update(TABLE_WORD, cv, ID + "=?", new String[] { selectedWord.id() + ""});
    }
  }

  private Word selectWord(int id) {
    Cursor cursor = getReadableDatabase().query(true, TABLE_WORD,
        new String[] { ID, QUESTION, SCORE, ANSWERDE, ANSWERFA },
        ID + "=?",
        new String[] { id + ""},
        null, null, null, null);
      Word word = null;
      if (cursor.moveToFirst()) {
        word = new Word(
          cursor.getInt(cursor.getColumnIndexOrThrow(ID)),
          cursor.getString(cursor.getColumnIndexOrThrow(QUESTION)),
          cursor.getInt(cursor.getColumnIndexOrThrow(SCORE)),
          cursor.getString(cursor.getColumnIndexOrThrow(ANSWERDE)),
          cursor.getString(cursor.getColumnIndexOrThrow(ANSWERFA)
        ));
      }
      if (cursor != null && !cursor.isClosed()) {
        cursor.close();
      }
      return word;
  }

}