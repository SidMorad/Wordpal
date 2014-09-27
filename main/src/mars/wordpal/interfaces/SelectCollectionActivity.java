package mars.wordpal.interfaces;

import android.support.v4.app.Fragment;

public class SelectCollectionActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new SelectCollectionFragment();
  }

}
