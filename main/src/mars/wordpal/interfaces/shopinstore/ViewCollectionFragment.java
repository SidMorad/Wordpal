package mars.wordpal.interfaces.shopinstore;

import java.util.ArrayList;
import java.util.TreeSet;

import mars.wordpal.R;
import mars.wordpal.application.util.BuildHelper;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewCollectionFragment extends Fragment {
  public static final String COLLECTION_NAME = "COLLECTION_NAME";
  private String collectionName;

  @TargetApi(11)
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    collectionName = getActivity().getIntent().getStringExtra(COLLECTION_NAME);

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
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
      Bundle savedInstanceState) {
    View convertView = inflater.inflate(R.layout.fragment_view_collection, parent, false);

    TextView cNameTextView = (TextView) convertView.findViewById(R.id.collection_name_id);
    ListView cListView = (ListView) convertView.findViewById(R.id.collection_content_list_id);

    WordCollection wc = WordCollectionsInMemory.get(collectionName);
    ViewCollectionAdapter vcAdapter = new ViewCollectionAdapter(wc.wordz());
    cNameTextView.setText(wc.name());
    cListView.setAdapter(vcAdapter);

    return convertView;
  }

  private class ViewCollectionAdapter extends BaseAdapter {
    private ArrayList<Word> words;

    public ViewCollectionAdapter(TreeSet<Word> wordz) {
      this.words = new ArrayList<Word>();
      this.words.addAll(wordz);
    }

    @Override
    public int getCount() {
      return words.size();
    }

    @Override
    public Object getItem(int position) {
      return words.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.viewcollection_item,
                                                                null);
      }
      TextView cNameTextView = findViewFromCache(convertView, R.id.question_id);

      Word word = (Word) getItem(position);
      cNameTextView.setText(word.getQuestion());

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