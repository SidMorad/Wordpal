package mars.wordpal.interfaces;

import mars.wordpal.R;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WordActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    String wordId = getIntent().getStringExtra(WordFragment.EXTRA_WORD_ID);
    return WordFragment.newInstance(wordId);
  }

  public void deToast(View v)  {
    ((TextView) findViewById(R.id.answer_id)).setText((String) v.getTag());
    ((Button) findViewById(R.id.not_sure_id)).
      setBackgroundResource(R.drawable.button_notsure_forsure);
  }

  public void faToast(View v)  {
    ((TextView) findViewById(R.id.answer_id)).setText((String) v.getTag());
    ((Button) findViewById(R.id.not_sure_id)).
    setBackgroundResource(R.drawable.button_notsure_forsure);
  }

  public void iKnow(View v) {
    Toast.makeText(this, v.getTag() + "+1", Toast.LENGTH_SHORT).show();
  }

  public void notSure(View v) {
    Toast.makeText(this, v.getTag() + "-1", Toast.LENGTH_SHORT).show();
  }

}