package mars.wordpal.infrastructure;

import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordpalDatabaseHelper extends SQLiteOpenHelper {
  private static final String DB_NAME = "wordpal.sqlite";
  private static final int VERSION = 1;
  private static final String COLLECTION = "collection";
  private static final String NAME = "name";
  private static final String QUESTION = "question";
  private static final String ANSWERDE = "answerde";
  private static final String ANSWERFA = "answerfa";
  private static final String WORD = "word";
  private static final String CID = "cid";

  public WordpalDatabaseHelper(Context context) {
    super(context, DB_NAME, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table collection ("
        + "id integer primary key autoincrement, "
        + "name varchar(255) unique )");
    db.execSQL("create table word ("
        + "id integer primary key autoincrement, "
        + "question varchar(255),"
        + "answerde varchar(255),"
        + "answerfa varchar(255),"
        + "cid integer references collection(id))");
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Implement schema changes here when upgrading
  }

  public long insert(WordCollection wordCollection) {
//TODO getReadableDatabase().rawQuery("select count(*) from collection where name = ?", new String[] {wordCollection.name()});
    ContentValues cv = new ContentValues();
    cv.put(NAME, wordCollection.name());
    long cid = getWritableDatabase().insert(COLLECTION, null, cv);
    if (cid != -1) {
      for (Word word : wordCollection.wordz()) {
        ContentValues wcv = new ContentValues();
        wcv.put(QUESTION, word.getQuestion());
        wcv.put(ANSWERDE, word.getAnswerDe());
        wcv.put(ANSWERFA, word.getAnswerFa());
        wcv.put(CID, cid);
        getWritableDatabase().insert(WORD, null, wcv);
      }
    }
    return cid;
  }

}