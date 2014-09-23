package mars.wordpal.interfaces;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

public class WordListActivity extends SingleFragmentActivity {
//  private static final String TAG = "WordListActivity";

  @Override
  protected Fragment createFragment() {
    return new WordListFragment();
  }

  public void deToast(View v)  {
    Toast.makeText(this, (String) v.getTag() , Toast.LENGTH_LONG).show();
  }

  public void faToast(View v)  {
    Toast.makeText(this, (String) v.getTag() , Toast.LENGTH_LONG).show();
  }

/*  public void iKnow(View v) {
    Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show();
  }

  public void notSure(View v) {
    Toast.makeText(this, "-1", Toast.LENGTH_SHORT).show();
  }*/

}