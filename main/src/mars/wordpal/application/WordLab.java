package mars.wordpal.application;

import java.util.ArrayList;

import mars.wordpal.domain.Word;

import android.content.Context;

public class WordLab {
  private static WordLab wordLab;
//  private Context appContext;
  private ArrayList<Word> words;

  public WordLab(Context appContext) {
//    this.appContext = appContext;
    this.words = new ArrayList<Word>();
    for (int i = 1; i < 3; i++) {
      Word s = new Word("Sentence going to be a little bit longer, perhaps two sentences. #" + i , "answerFa" + i, "answerDe" + i, i);
      words.add(s);
    }
  }

  public static WordLab get(Context c) {
    if (wordLab == null) {
      wordLab = new WordLab(c.getApplicationContext());
    }
    return wordLab;
  }

  public ArrayList<Word> getWords() {
    return words;
  }

  public Word getSentence(String question) {
    for (Word word : words) {
      if (question.equalsIgnoreCase(word.getQuestion())) {
        return word;
      }
    }
    return null;
  }

}