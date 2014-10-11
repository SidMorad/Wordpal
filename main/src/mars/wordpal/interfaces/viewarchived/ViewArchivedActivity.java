package mars.wordpal.interfaces.viewarchived;

import mars.wordpal.interfaces.SingleFragmentActivity;
import android.support.v4.app.Fragment;

public class ViewArchivedActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new ViewArchivedFragment();
  }

}