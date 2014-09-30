package mars.wordpal.interfaces.settings;

import android.support.v4.app.Fragment;
import mars.wordpal.interfaces.SingleFragmentActivity;

public class SettingsActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new SettingsFragment();
  }

}