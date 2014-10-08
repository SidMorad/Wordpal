package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.DatabaseManager;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectCollectionFragment extends Fragment {

  private DatabaseManager collectionManager;

//  private static final String TAG = "SelectCollectionFragment";

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    collectionManager = new DatabaseManager(getActivity());
  }

  @TargetApi(11)
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_select_collection, parent, false);

    GridView gridView = (GridView) v.findViewById(R.id.selectCollectionContainer);
    final ArrayList<WordCollection> userCollections = collectionManager.userCollections();
    gridView.setAdapter(new CollectionAdapter(v.getContext(), userCollections));

    gridView.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position,
          long id) {
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
          int color = ((ColorDrawable) background).getColor();
          if (color == Color.WHITE) {
            view.setBackgroundColor(Color.CYAN);
            WordCollection wordCollection = userCollections.get(position);
            collectionManager.markCollectionAsActive(wordCollection);
            Toast.makeText(view.getContext(),
              ((TextView) view.findViewById(R.id.collectionName))
              .getText() + " is active now ", Toast.LENGTH_SHORT).show();
          }
          else {
            view.setBackgroundColor(Color.WHITE);
            WordCollection wordCollection = userCollections.get(position);
            collectionManager.markCollectionAsNotActive(wordCollection);
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