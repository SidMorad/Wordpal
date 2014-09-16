package mars.wordpal.domain;

public class Word {

  private String question;
  private String answerFa;
  private String answerDe;

  public Word(String question, String answerfa, String answerde) {
    this.question = question;
    this.answerFa = answerfa;
    this.answerDe = answerde;
  }

  // -- getters
  public String getQuestion() { return question; }
  public String getAnswerFa() { return answerFa; }
  public String getAnswerDe() { return answerDe; }

  @Override
  public String toString() {
    return question;
  }
}