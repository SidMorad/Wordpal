package mars.wordpal.infrastructure;

import java.util.TreeSet;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

public class WordCollectionsInMemory {

  public static WordCollection wordTrainerLesson1() {
    TreeSet<Word> wordz = new TreeSet<Word>(WordComparator.getInstance());
    wordz.add(new Word("I", "Ich", "من", 0));
    wordz.add(new Word("I and you", "ich und du", "من و تو", 0));
    wordz.add(new Word("both of us", "wir beide", "هر دو ما", 0));

    wordz.add(new Word("he", "er", "او (مرد)", 0));
    wordz.add(new Word("he and she", "er und sie", "او (مرد) و او (زن)", 0));
    wordz.add(new Word("they both", "sie beide", "هر دو آنها", 0));

    wordz.add(new Word("the man", "der Mann", "مرد", 0));
    wordz.add(new Word("the woman", "die Frau", "زن", 0));
    wordz.add(new Word("the child", "das Kind", "بچه", 0));

    wordz.add(new Word("a family", "eine Familie", "یک خانواده", 0));
    wordz.add(new Word("my family", "meine Familie", "خانواده من", 0));
    wordz.add(new Word("My family is here", "Meine Familie ist hier", "خانوادم اینجاست", 0));

    wordz.add(new Word("I am here", "Ich bin hier", "من اینجا هستم", 0));
    wordz.add(new Word("You are here.", "Du bist hier", "تو اینجا هستی", 0));
    wordz.add(new Word("He is here and she is here", "Er ist hier und sie ist hier", "او اینجاست و او اینجاست", 0));

    wordz.add(new Word("We are here", "Wir sind hier", "ما اینجا هستیم", 0));
    wordz.add(new Word("You are here.", "Ihr seid hier", "شما اینجا هستید", 0));
    wordz.add(new Word("They are all here", "Sie sind alle hier", "آنها همه اینجا هستند", 0));

    
    WordCollection people = new WordCollection(
        "WordTrainer Lesson1: People - Personen", wordz);
    return people;
  }

  public static Word get(String question) {
    for (Word word : wordTrainerLesson1().wordz()) {
      if (word.getQuestion().equalsIgnoreCase(question)) {
        return word;
      }
    }
    return null;
  }

}