package mars.wordpal.interfaces.help;

import mars.wordpal.interfaces.SingleFragmentActivity;
import android.support.v4.app.Fragment;

public class HelpActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new HelpFragment();
  }

}