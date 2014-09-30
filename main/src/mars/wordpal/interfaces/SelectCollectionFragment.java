package mars.wordpal.interfaces;

import mars.wordpal.R;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class SelectCollectionFragment extends Fragment {

//  private static final String TAG = "SelectCollectionFragment";

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

    GridView gridView = (GridView) v.findViewById(R.id.selectCollectionContainer);
    gridView.setAdapter(new CollectionAdapter(v.getContext(), WordCollectionsInMemory.CollectionNames()));

    gridView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position,
          long id) {
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
          int color = ((ColorDrawable) background).getColor();
          if (color == Color.WHITE) {
            view.setBackgroundColor(Color.CYAN);
            Toast.makeText(view.getContext(),
              ((TextView) view.findViewById(R.id.collectionName))
              .getText() + " is active now", Toast.LENGTH_SHORT).show();
          }
          else {
            view.setBackgroundColor(Color.WHITE);
            Toast.makeText(view.getContext(),
                ((TextView) view.findViewById(R.id.collectionName))
                .getText() + " is deactive now", Toast.LENGTH_SHORT).show();
          }
        }
        else {
          Toast.makeText(view.getContext(), "background color not found", Toast.LENGTH_SHORT);
        }
      }
    });

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