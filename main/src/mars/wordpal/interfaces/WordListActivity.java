package mars.wordpal.interfaces;

import mars.wordpal.R;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

public class WordListActivity extends SingleFragmentActivity {
//  private static final String TAG = "WordListActivity";

  @Override
  protected Fragment createFragment() {
    return new WordListFragment();
  }

  public void goToSelectCollection(View v) {
    Intent i = new Intent(this, SelectCollectionActivity.class);
    startActivity(i);
  }

  public void deToast(View v)  {
    TextView answerTextView = (TextView) findViewById(R.id.answer_id);
    answerTextView.setText((String) v.getTag()); 
  }

  public void faToast(View v)  {
    TextView answerTextView = (TextView) findViewById(R.id.answer_id);
    answerTextView.setText((String) v.getTag()); 
  }

}