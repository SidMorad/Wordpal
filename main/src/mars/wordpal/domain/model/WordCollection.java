package mars.wordpal.domain.model;

import java.util.ArrayList;
import java.util.TreeSet;


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

  public ArrayList<Word> nextTwo() {
    if (counter == 0) {
      return null;
    }
    ArrayList<Word> words = new ArrayList<Word>();
    words.add(wordz.pollFirst());
    counter--;
    if (counter == 0) {
      return words;
    }
    counter--;
    words.add(wordz.pollFirst());
    return words;
  }

  public Word nextOne() {
    if (counter == 0) {
      return null;
    }
    counter--;
    return wordz.pollFirst();
  }

}