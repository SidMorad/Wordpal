package mars.wordpal.infrastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import mars.wordpal.domain.model.Settings;
import android.content.Context;

public class WordpalJSONSerializer {
  private Context context;
  private final String setting_filename = "settings.json";

  public WordpalJSONSerializer(Context c) {
    this.context = c;
  }

  public void saveSettings(Settings settings) throws IOException, JSONException {
    Writer writer = null;
    try {
      OutputStream out = context.openFileOutput(setting_filename, Context.MODE_PRIVATE);
      writer = new OutputStreamWriter(out);
      writer.write(settings.toJSON().toString());
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }

  public Settings loadSettings() throws IOException, JSONException{
    BufferedReader reader = null;
    try {
      InputStream in = context.openFileInput(setting_filename);
      reader = new BufferedReader(new InputStreamReader(in));
      StringBuilder jsonString = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        jsonString.append(line);
      }
      JSONObject jsonObject = new JSONObject(new JSONTokener(jsonString.toString()));
      return new Settings(jsonObject);
    } catch (FileNotFoundException fnfe) {
      // Ignore this, it happens first time only.
    } finally {
      if (reader != null) {
        reader.close();
      }
    }
    return new Settings(10);
  }
}