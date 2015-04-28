package mars.wordpal.interfaces.shopinstore;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.application.util.BuildHelper;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class ShopInStoreFragment extends ListFragment {

  private ArrayList<WordCollection> wordCollections;
  private ShopInStoreAdapter shopInStoreAdapter;

  @TargetApi(11)
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    wordCollections = WordCollectionsInMemory.originalCollections();
    shopInStoreAdapter = new ShopInStoreAdapter(wordCollections);
    setListAdapter(shopInStoreAdapter);

    if (BuildHelper.api11orHigher()) {
      if (NavUtils.getParentActivityIntent(getActivity()) != null) {
        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
      }
    }
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
    case android.R.id.home:
      if (NavUtils.getParentActivityIntent(getActivity()) != null) {
        NavUtils.navigateUpFromSameTask(getActivity());
      }
      return true;
    default:
      return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    ((ShopInStoreAdapter) getListAdapter()).notifyDataSetChanged();
  }

  private class ShopInStoreAdapter extends BaseAdapter {
    private ArrayList<WordCollection> wordCollections;

    public ShopInStoreAdapter(ArrayList<WordCollection> wordCollections) {
      this.wordCollections = wordCollections;
    }

    @Override
    public int getCount() {
      return wordCollections.size();
    }

    @Override
    public Object getItem(int position) {
      return wordCollections.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.shopinstore_item,
                                                                parent);
      }
      TextView collectionName = findViewFromCache(convertView, R.id.collection_name_id);
      Button viewButton = findViewFromCache(convertView, R.id.view_collection_id);
      Button buyButton = findViewFromCache(convertView, R.id.buy_collection_id);

      WordCollection wordCollection = (WordCollection) getItem(position);
      collectionName.setText(wordCollection.name());
      viewButton.setTag(wordCollection.name());
      buyButton.setTag(wordCollection.name());
      return convertView;
    }

  }

  @SuppressWarnings("unchecked")
  public static <T extends View> T findViewFromCache(View view, int id) {
    SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
    if (viewHolder == null) {
      viewHolder = new SparseArray<View>();
      view.setTag(viewHolder);
    }
    View childView = viewHolder.get(id);
    if (childView == null) {
      childView = view.findViewById(id);
      viewHolder.put(id, childView);
    }
    return (T) childView;
  }


}