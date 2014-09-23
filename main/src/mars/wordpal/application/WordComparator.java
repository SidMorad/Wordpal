package mars.wordpal.application;

import java.util.Comparator;

import mars.wordpal.domain.Word;

public class WordComparator implements Comparator<Word> {

  private static WordComparator instance;

  public static WordComparator getInstance() {
    if (instance == null) {
      instance = new WordComparator();
    }
    return instance;
  }

  @Override
  public int compare(Word word1, Word word2) {
    if (word1 == null || word2 == null) {
      return 0;
    }
    if (word1.getQuestion().equalsIgnoreCase(word2.getQuestion()) &&
        word1.getScore() == word2.getScore()) {
      return 0;
    }
    if (word1.getScore() >= word2.getScore()) {
      return +1;
    } else {
      return -1;
    }
  }

}