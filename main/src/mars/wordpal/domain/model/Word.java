package mars.wordpal.domain.model;

import mars.wordpal.application.comparator.WordComparator;
import mars.wordpal.domain.shared.ValueObject;

public class Word implements Comparable<Word>, ValueObject<Word> {

  private int id;
  private String question;
  private int score;
  private String answerFa;
  private String answerDe;

  public Word(int id, String question, int score, String answerde, String answerfa) {
    this.id = id;
    this.question = question;
    this.score = score;
    this.answerDe = answerde;
    this.answerFa = answerfa;
  }

  public Word(String question, String answerde, String answerfa, int score) {
    this(0, question, score, answerde, answerfa);
  }

  public void addScore1Up() {
    if (score == 10) {
      return;
    }
    score++;
  }

  public void minesScore1Down() {
    if (score == 0) {
      return;
    }
    score--;
  }

  // -- getters
  public String getQuestion() { return question; }
  public String getAnswerDe() { return answerDe; }
  public String getAnswerFa() { return answerFa; }
  public int score() { return score; }
  public int id() { return id; }

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