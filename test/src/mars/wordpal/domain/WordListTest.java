package mars.wordpal.domain;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

import junit.framework.TestCase;

public class WordListTest extends TestCase {

  public void testWordListTwoByTwo() {
    TreeSet<Word> wordz = new TreeSet<Word>();
    wordz.add(new Word("Q4", "A-fa-4", "A-de-4", 4));
    wordz.add(new Word("Q3", "A-fa-3", "A-de-3", 3));
    wordz.add(new Word("Q2", "A-fa-2", "A-de-2", 2));
    wordz.add(new Word("Q1", "A-fa-1", "A-de-1", 1));
    assertFalse("No duplicate question allowed", wordz.add(new Word("Q2", "A-fa-2", "A-de-2", 2)));

    WordCollection wordCollection = new WordCollection(0, "CollectionG", wordz, true);
    assertEquals(4, wordCollection.wordz().size());
    assertEquals(1, wordCollection.wordz().first().score());
    assertEquals(4, wordCollection.wordz().last().score());

    ArrayList<Word> firstTwo = wordCollection.nextTwo();
    assertEquals(2, firstTwo.size());
    assertEquals(2, wordCollection.wordz().size());
    assertEquals("Q1", firstTwo.get(0).getQuestion());
    assertEquals("Q2", firstTwo.get(1).getQuestion());

    ArrayList<Word> nextTwo = wordCollection.nextTwo();
    assertEquals("Q3", nextTwo.get(0).getQuestion());
    assertEquals("Q4", nextTwo.get(1).getQuestion());

    assertNull(wordCollection.nextTwo());
  }

}