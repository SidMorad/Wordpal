package mars.wordpal.domain.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Settings {

  public static final String RIGHT_NUMBER = "right_number";

  int rightNumber = 10;     // rightNumber default value is 10

  public Settings(int rightNumber) {
    this.rightNumber = rightNumber;
  }

  public Settings(JSONObject json) throws JSONException {
    if (json.has(RIGHT_NUMBER)) {
      rightNumber = json.getInt(RIGHT_NUMBER);
    }
  }

  public JSONObject toJSON() throws JSONException {
    JSONObject json = new JSONObject();
    json.put(RIGHT_NUMBER, rightNumber);
    return json;
  }

  public int rightNumber() {
    return rightNumber;
  }

  public void setRightNumber(int rightNumber) {
    this.rightNumber = rightNumber;
  }
}