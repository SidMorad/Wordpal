package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.domain.model.WordCollection;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if (convertView == null) {
      View view = new View(context);

      view = inflater.inflate(R.layout.fragment_select_collection_fields,
                                  null);

      TextView textView = (TextView) view.findViewById(R.id.collectionName);
      Log.d("WP", "collection return for position [" + position + "] value [" + collections.get(position).name() + "]");
      textView.setText(collections.get(position).name());
      convertView = view;
    }
    else {
      TextView textView = (TextView) convertView.findViewById(R.id.collectionName);
      Log.d("WP", "collection return for position [" + position + "] value [" + collections.get(position).name() + "]");
      textView.setText(collections.get(position).name());
    }

    if (collections.get(position).active()) {
      convertView.setBackgroundColor(Color.GREEN);
    }
    else {
      convertView.setBackgroundColor(Color.WHITE);
    }

    return convertView;
  }

}