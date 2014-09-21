package mars.wordpal.domain;

import mars.wordpal.application.WordComparator;
import mars.wordpal.domain.shared.ValueObject;

public class Word implements Comparable<Word>, ValueObject<Word> {

  private String question;
  private String answerFa;
  private String answerDe;
  private int score;

  public Word(String question, String answerde, String answerfa, int score) {
    this.question = question;
    this.answerDe = answerde;
    this.answerFa = answerfa;
    this.score = score;
  }

  // -- getters
  public String getQuestion() { return question; }
  public String getAnswerDe() { return answerDe; }
  public String getAnswerFa() { return answerFa; }
  public int getScore() { return score; }

  @Override
  public String toString() {
    return question;
  }

  @Override
  public int compareTo(Word another) {
    return WordComparator.getInstance().compare(this, another);
  }

  @Override
  public boolean sameValueAs(Word other) {
    return other != null &&
        other.question.equals(question) &&
        other.answerDe.equals(answerDe) &&
        other.answerFa.equals(answerFa);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (o == null || o.getClass() != getClass()) return false;

    Word word = (Word) o;
    return sameValueAs(word);
  }

  @Override
  public int hashCode() {
    return question.hashCode() +
        answerDe.hashCode() +
        answerFa.hashCode();
  }

  private static final long serialVersionUID = 1L;
}