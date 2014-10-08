package mars.wordpal.interfaces.settings;

import mars.wordpal.R;
import mars.wordpal.domain.model.Settings;
import mars.wordpal.infrastructure.DatabaseManager;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsFragment extends Fragment {

  private DatabaseManager databaseManager;
//  private static final String TAG = "SettingsFragment";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    databaseManager = new DatabaseManager(getActivity());
  }

  @TargetApi(11)
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
      Bundle savedInstanceState) {
    final View v = inflater.inflate(R.layout.fragment_settings, parent, false);

    final EditText editText = (EditText) v.findViewById(R.id.editRightNumber);
    editText.setText(databaseManager.rightNumber() + "");
    editText.addTextChangedListener(new TextWatcher() {
      public void onTextChanged(CharSequence s, int start, int before, int count) {}
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
      public void afterTextChanged(Editable s) {
        if (isInt(editText.getText().toString())) {
          Integer rightNumber = Integer.valueOf(editText.getText().toString());
          if (rightNumber < 4) {
            Toast.makeText(v.getContext(), "Should be higher than 3", Toast.LENGTH_SHORT).show();
          }
          else {
            Settings settings = databaseManager.loadSettings();
            settings.setRightNumber(rightNumber);
            databaseManager.storeSettings(settings);
          }
        }
      }
    });

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      if (NavUtils.getParentActivityIntent(getActivity()) != null) {
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
      }
    }

    return v;
  }

  private boolean isInt(String text) {
    try {
      Integer.parseInt(text);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
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