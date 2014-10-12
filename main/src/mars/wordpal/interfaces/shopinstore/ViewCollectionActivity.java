package mars.wordpal.interfaces.shopinstore;

import mars.wordpal.interfaces.SingleFragmentActivity;
import android.support.v4.app.Fragment;

public class ViewCollectionActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new ViewCollectionFragment();
  }

}