package mars.wordpal.infrastructure;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

public class WordCollectionsInMemory {

  public static Word get(String question) {
    for (Word word : wordTrainerLesson1().wordz()) {
      if (word.getQuestion().equalsIgnoreCase(question)) {
        return word;
      }
    }
    return null;
  }

  public static WordCollection getCollection(String collectionName) {
    if (collectionName.equalsIgnoreCase(wordTrainerLesson1().name())) {
      return wordTrainerLesson1();
    }
    else if (collectionName.equalsIgnoreCase(wordTrainerLesson2().name())) {
      return wordTrainerLesson2();
    }
    return null;
  }

  public static ArrayList<String> CollectionNames() {
    ArrayList<String> collectionNames = new ArrayList<String>();
    collectionNames.add(wordTrainerLesson1().name());
    collectionNames.add(wordTrainerLesson2().name());
    return collectionNames;
  }

  public static WordCollection wordTrainerLesson1() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("I", "Ich", "من", 0));
    w.add(new Word("I and you", "ich und du", "من و تو", 0));
    w.add(new Word("both of us", "wir beide", "هر دو ما", 0));
    w.add(new Word("he", "er", "او (مرد)", 0));
    w.add(new Word("he and she", "er und sie", "او (مرد) و او (زن)", 0));
    w.add(new Word("they both", "sie beide", "هر دو آنها", 0));
    w.add(new Word("the man", "der Mann", "مرد", 0));
    w.add(new Word("the woman", "die Frau", "زن", 0));
    w.add(new Word("the child", "das Kind", "بچه", 0));
    w.add(new Word("a family", "eine Familie", "یک خانواده", 0));
    w.add(new Word("my family", "meine Familie", "خانواده من", 0));
    w.add(new Word("My family is here", "Meine Familie ist hier", "خانوادم اینجاست", 0));
    w.add(new Word("I am here", "Ich bin hier", "من اینجا هستم", 0));
    w.add(new Word("You are here.", "Du bist hier", "تو اینجا هستی", 0));
    w.add(new Word("He is here and she is here", "Er ist hier und sie ist hier", "او اینجاست و او اینجاست", 0));
    w.add(new Word("We are here", "Wir sind hier", "ما اینجا هستیم", 0));
    w.add(new Word("You are here.", "Ihr seid hier", "شما اینجا هستید", 0));
    w.add(new Word("They are all here", "Sie sind alle hier", "آنها همه اینجا هستند", 0));
    return new WordCollection(
        "WordTrainer Lesson1: People - Personen", w);
  }

  public static WordCollection wordTrainerLesson2() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("the grandfather", "der Großvater", "پدربزرگ", 0));
    w.add(new Word("the grandmother", "die Großmutter", "مادربزرگ", 0));
    w.add(new Word("he and she", "er und sie", "او و او", 0));
    w.add(new Word("the father", "der Vater", "پدر", 0));
    w.add(new Word("the mother", "die Mutter", "مادر",0));
    w.add(new Word("the son", "der Sohn", "پسر", 0));
    w.add(new Word("the daughter", "die Tochter", "دختر", 0));
    w.add(new Word("the brother", "der Bruder", "برادر", 0));
    w.add(new Word("the sister", "die Schwester", "خواهر", 0));
    w.add(new Word("the uncle", "der Onkel","دایی یا عمو", 0));
    w.add(new Word("the aunt", "die Tante", "خاله یا عمه", 0));
    w.add(new Word("We are a family", "Wir sind eine Familie", "ما یک خانواده هستیم", 0));
    w.add(new Word("The family is not small", "Die Familie ist nicht klein", "خانواده کوچک نیست", 0));
    w.add(new Word("The family is big", "Die Familie ist groß", "خانواده بزرگ است", 0));
    return new WordCollection(
        "WordTrainer Lesson2: Family Members - Familie", w);
  }

}