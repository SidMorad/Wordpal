package mars.wordpal.interfaces;

import android.support.v4.app.Fragment;

public class WordActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new WordFragment();
  }

}