package mars.wordpal.interfaces.help;

import android.support.v4.app.Fragment;
import mars.wordpal.interfaces.SingleFragmentActivity;

public class HelpActivity extends SingleFragmentActivity {

  @Override
  protected Fragment createFragment() {
    return new HelpFragment();
  }

}