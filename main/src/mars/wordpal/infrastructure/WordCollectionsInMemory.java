package mars.wordpal.infrastructure;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;

public class WordCollectionsInMemory {

  public static ArrayList<WordCollection> originalCollections() {
    ArrayList<WordCollection> originalCollections = new ArrayList<WordCollection>();
    originalCollections.add(wordTrainerLesson1());
    originalCollections.add(wordTrainerLesson2());
    originalCollections.add(wordTrainerLesson3());
    originalCollections.add(wordTrainerLesson4());
    return originalCollections;
  }

  public static WordCollection wordTrainerLesson4() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Where are we?", "Wo sind wir?", "ما کجاییم؟", 0));
    w.add(new Word("We are at school.", "Wir sind in der Schule.", "ما در مدرسه هستیم.", 0));
    w.add(new Word("We are having class/a lesson.", "Wir haben Unterricht.", "ما یک کلاس داریم", 0));
    w.add(new Word("Those are the school children.", "Das sind die Schüler.", "آنها بچه‌های مدرسه هستند. ", 0));
    w.add(new Word("That is the teacher", "Das ist die Lehrerin.", "آن یک معلم است.", 0));
    w.add(new Word("That is class.", "Das ist die Klasse.", "آن کلاس است.", 0));
    w.add(new Word("What are we doing?", "Was machen wir?", "ما چه کار می‌کنیم؟", 0));
    w.add(new Word("We are learning.", "Wir lernen.", "ما یاد می‌گیریم", 0));
    w.add(new Word("We are learning a language.", "Wir lernen eine Sprache.", "ما یک زبان یاد می‌گیریم.", 0));
    w.add(new Word("I learn English.", "Ich lerne Englisch.", "من انگلیسی یاد می‌گیرم.", 0));
    w.add(new Word("You learn Spanish.", "Du lernst Spanisch.", "تو اسپانیایی یاد می‌گیری.", 0));
    w.add(new Word("He learns German.", "Er lernt Deutsch.", "او آلمانی یاد می‌گیرد.", 0));
    w.add(new Word("We learn French.", "Wir lernen Französisch.", "ما فرانسه یاد می‌گیریم.", 0));
    w.add(new Word("You all learn Italian.", "Ihr lernt Italienisch.", "شما اتالیایی یاد می‌گیرید.", 0));
    w.add(new Word("They learn Russian.", "Sie lernen Russisch.", "آنها روسی یاد می‌گیرند.", 0));
    w.add(new Word("Learning languages is interesting.", "Sprachen lernen ist interessant.", "یادگیری زبان‌ها جالب است.", 0));
    w.add(new Word("We want to understand people.", "Wir wollen Menschen verstehen.", "ما می‌خواهیم مردم رو بفهمیم.", 0));
    w.add(new Word("We want to speak with people.", "Wir wollen mit Menschen sprechen.", "ما می‌خواهیم با مردم صحبت کنیم.", 0));
    return new WordCollection(0,
      "Wordtrainer Lesson4: At school - In der Schule", w, true);
  }

  public static WordCollection wordTrainerLesson3() {
    TreeSet<Word> w = new TreeSet<Word>(WordComparator.getInstance());
    w.add(new Word("Hi!", "Hallo!", "سلام!", 0));
    w.add(new Word("Hello!", "Guten Tag!", "سلام!", 0));
    w.add(new Word("How are you?", "Wie geht's?", "چطوری؟", 0));
    w.add(new Word("Do you come from Europe?", "Kommen Sie aus Europa?", "شما از اروپا می‌آیید؟", 0));
    w.add(new Word("Do you come from America?", "Kommen Sie aus Amerika?", "شما از آمریکا می‌آیید؟", 0));
    w.add(new Word("Do you come from Asia?", "Kommen Sie aus Asien?", "شما از آسیا می‌آیید؟", 0));
    w.add(new Word("In which hotel are you staying?", "In welchem Hotel wohnen Sie?", "در کدام هتل اقامت دارید؟", 0));
    w.add(new Word("How long have you been here for?", "Wie lange sind Sie schon hier?", "چند وقته که اینجایید؟", 0));
    w.add(new Word("How long will you be staying?", "Wie lange bleiben Sie?", "چند وقت می‌خواهید اینجا بمانید؟", 0));
    w.add(new Word("Do you here on vacation?", "Machen Sie hier Urlaub?", "برای تعطیلات اینجا هستید؟", 0));
    w.add(new Word("Please do visit me sometime!", "Besuchen Sie mich mal!", "لطفا گاهی‌اوقات به دیدن من بیا!", 0));
    w.add(new Word("Here is my address.", "Hier ist meine Adresse.", "این آدرس من است.", 0));
    w.add(new Word("Shall we see each other tomorrow?", "Sehen wir uns morgen?", "فردا همدیگر رو ببینیم؟", 0));
    w.add(new Word("I am sorry, but I already have plans.", "Tut mir Leid, ich habe schon etwas vor.", "من متاسفم، برای فردا برنامه دیگری دارم.", 0));
    w.add(new Word("Bye!", "Tschüs!", "خداحافظ!", 0));
    w.add(new Word("Good bye!", "Auf Wiedersehen!", "خداحافظ!", 0));
    w.add(new Word("See you soon!", "Bis bald!", "زود می‌بینمت!", 0));
    return new WordCollection(0,
        "Wordtrainer Lesson 3: Getting to know others - Kennen lernen", w, true);
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
    return new WordCollection(0,
        "WordTrainer Lesson2: Family Members - Familie", w, false);
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
    return new WordCollection(0,
        "WordTrainer Lesson1: People - Personen", w, true);
  }

}