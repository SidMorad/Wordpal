package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CollectionAdapter extends BaseAdapter {

  private Context context;
  private final ArrayList<String> collectionNames;

  public CollectionAdapter(Context context, ArrayList<String> list) {
    this.context = context;
    this.collectionNames = list;
  }

  @Override
  public int getCount() {
    return collectionNames.size();
  }

  @Override
  public Object getItem(int position) {
    return collectionNames.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View gridView;
    if (convertView == null) {
      gridView = new View(context);

      gridView = inflater.inflate(R.layout.fragment_select_collection_fields, null);

      TextView textView = (TextView) gridView.findViewById(R.id.collectionName);
      textView.setText(collectionNames.get(position));

    }
    else {
      gridView = convertView;
    }

    if (position % 2 == 0) {
      gridView.setBackgroundColor(Color.WHITE);
    }
    else {
      gridView.setBackgroundColor(Color.CYAN);
    }

    return gridView;
  }

}