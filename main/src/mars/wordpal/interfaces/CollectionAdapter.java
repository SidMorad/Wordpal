package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.domain.model.WordCollection;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CollectionAdapter extends BaseAdapter {

  private Context context;
  private final ArrayList<WordCollection> collections;

  public CollectionAdapter(Context context, ArrayList<WordCollection> list) {
    this.context = context;
    this.collections = list;
  }

  @Override
  public int getCount() {
    return collections.size();
  }

  @Override
  public Object getItem(int position) {
    return collections.get(position);
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
      textView.setText(collections.get(position).name());

    }
    else {
      gridView = convertView;
    }

    if (collections.get(position).active()) {
      gridView.setBackgroundColor(Color.CYAN);
    }
    else {
      gridView.setBackgroundColor(Color.WHITE);
    }

    return gridView;
  }

}