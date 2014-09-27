package mars.wordpal.interfaces;

import mars.wordpal.R;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

public class SelectCollectionFragment extends Fragment {

  private TextView collectionName;
  private CheckBox collectionenabled;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }

  @TargetApi(11)
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_select_collection, parent, false);
    collectionName = (TextView) v.findViewById(R.id.collectionName);
    collectionName.setText(WordCollectionsInMemory.wordTrainerLesson1().name());
    collectionenabled = (CheckBox) v.findViewById(R.id.collectionEnabled);
    collectionenabled.setSelected(true);

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
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
        if (NavUtils.getParentActivityIntent(getActivity()) != null) {
          NavUtils.navigateUpFromSameTask(getActivity());
        }
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}