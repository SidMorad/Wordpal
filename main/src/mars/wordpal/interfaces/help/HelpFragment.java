package mars.wordpal.interfaces.help;

import mars.wordpal.R;
import mars.wordpal.application.util.BuildHelper;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class HelpFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setHasOptionsMenu(true);
  }

  @TargetApi(11)
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    final View v = inflater.inflate(R.layout.fragment_help, container, false);

    if (BuildHelper.api11orHigher()) {
      if (NavUtils.getParentActivityIntent(getActivity()) != null) {
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
      }
    }

    return v;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch(item.getItemId()) {
    case android.R.id.home:
      if (BuildHelper.api11orHigher()) {
        if (NavUtils.getParentActivityIntent(getActivity()) != null) {
          NavUtils.navigateUpFromSameTask(getActivity());
        }
      }
      return true;
      default :
        return super.onOptionsItemSelected(item);
    }
  }

}