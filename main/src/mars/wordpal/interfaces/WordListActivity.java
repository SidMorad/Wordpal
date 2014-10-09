package mars.wordpal.interfaces;

import mars.wordpal.R;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

public class WordListActivity extends SingleFragmentActivity {
//  private static final String TAG = "WordListActivity";

  @Override
  protected Fragment createFragment() {
    return new WordListFragment();
  }

  public void resetActivity(View v) {
    if (Build.VERSION.SDK_INT >= 11) {
      recreate();
    }
    else {
      Intent intent = getIntent();
      intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
      finish();
      overridePendingTransition(0, 0);
      startActivity(intent);
      overridePendingTransition(0, 0);
    }
  }

  public void exitActivity(View v) {
    finish();
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