package mars.wordpal.interfaces;

import android.support.v4.app.Fragment;

public class WordListActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new WordListFragment();
  }

}