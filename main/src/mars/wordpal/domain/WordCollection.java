package mars.wordpal.domain;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.WordComparator;

public class WordCollection {

  private String name;
  private int counter = 0;
  private final TreeSet<Word> wordz = new TreeSet<Word>(WordComparator.getInstance());

  public WordCollection(String name, TreeSet<Word> wordsz) {
    this.name = name;
    this.wordz.addAll(wordsz);
    this.counter = wordz.size();
  }

  public String name() {
    return name;
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

}