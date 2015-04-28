package mars.wordpal.domain.model;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.util.BuildHelper;
import android.annotation.TargetApi;


public class WordCollection {

  private int id;
  private String name;
  private Boolean active;
  private int counter = 0;
  private TreeSet<Word> wordz;

  public WordCollection(int id, String name, TreeSet<Word> wordsz, boolean active) {
    this.id = id;
    this.name = name;
    this.active = active;
    this.wordz = wordsz;
    this.counter = wordz == null ? 0 : wordz.size();
  }

  public int id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Boolean active() {
    return active;
  }

  public TreeSet<Word> wordz() {
    return wordz;
  }

  @TargetApi(9)
  public ArrayList<Word> nextTwo() {
    if (counter == 0) {
      return null;
    }
    ArrayList<Word> words = new ArrayList<Word>();
    if (BuildHelper.api9orHigher()) {
      words.add(wordz.pollFirst());
    }
    else {
      words.add(wordz.first());
      wordz.remove(wordz.first());
    }
    counter--;
    if (counter == 0) {
      return words;
    }
    counter--;
    if (BuildHelper.api9orHigher()) {
      words.add(wordz.pollFirst());
    }
    else {
      words.add(wordz.first());
      wordz.remove(wordz.first());
    }
    return words;
  }

  @TargetApi(9)
  public Word nextOne() {
    if (counter == 0) {
      return null;
    }
    counter--;
    if (BuildHelper.api9orHigher()) {
      return wordz.pollFirst();
    }
    else {
      Word first = wordz.first();
      wordz.remove(first);
      return first;
    }
  }

}