package mars.wordpal.infrastructure;

import java.io.IOException;
import java.util.ArrayList;

import mars.wordpal.domain.model.Settings;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

import org.json.JSONException;

import android.content.Context;

public class DatabaseManager {
  private Context context;
  private WordpalDatabaseHelper wordpalDatabaseHelper;
  private WordpalJSONSerializer wordpalJSONSerializer;
  private Settings settings;

  public DatabaseManager(Context context) {
    this.context = context;
    this.wordpalDatabaseHelper = new WordpalDatabaseHelper(this.context);
    this.wordpalJSONSerializer = new WordpalJSONSerializer(this.context);
    this.settings = loadSettings();
  }

  public long insertCollection(WordCollection wordCollection) {
    return wordpalDatabaseHelper.insertCollection(wordCollection);
  }

  public int rightNumber() {
    return settings.rightNumber();
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

  public WordCollection currentCollection() {
    return wordpalDatabaseHelper.currentCollection(rightNumber());
  }

  public void updateWordScorePlus(Word word) {
    wordpalDatabaseHelper.updateWordScorePlus(word, rightNumber());
  }

  public void updateWordScoreMines(Word word) {
    wordpalDatabaseHelper.updateWordScoreMines(word);
  }

  public Settings loadSettings() {
    try {
      return settings = wordpalJSONSerializer.loadSettings();
    } catch (IOException io) {
    } catch (JSONException jo) {
    }
    return new Settings(10);
  }

  public void storeSettings(Settings settings) {
    try {
      wordpalJSONSerializer.saveSettings(settings);
      this.settings = settings;
    } catch (IOException e) {
    } catch (JSONException e) {
    }
  }

}