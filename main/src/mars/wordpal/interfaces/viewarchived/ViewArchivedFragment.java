package mars.wordpal.interfaces.viewarchived;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.application.util.BuildHelper;
import mars.wordpal.domain.model.Word;
import mars.wordpal.infrastructure.DatabaseManager;
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

public class ViewArchivedFragment extends ListFragment {

  private ArrayList<Word> wordArchived;
  private ViewArchivedAdapter viewArchivedAdapter;
  private DatabaseManager databaseManager;

  @TargetApi(11)
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
    databaseManager = new DatabaseManager(getActivity());
    wordArchived = databaseManager.wordArchived();
    viewArchivedAdapter = new ViewArchivedAdapter(wordArchived);
    setListAdapter(viewArchivedAdapter);

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
    ((ViewArchivedAdapter) getListAdapter()).notifyDataSetChanged();
  }

  private class ViewArchivedAdapter extends BaseAdapter {
    private ArrayList<Word> wordz;

    public ViewArchivedAdapter(ArrayList<Word> wordz) {
      this.wordz = wordz;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

      if (convertView == null) {
        convertView = getActivity().getLayoutInflater().inflate(R.layout.wordarchived_item,
                                                                parent);
      }
      TextView question = ViewHolder.get(convertView, R.id.question_id);
      final TextView score = ViewHolder.get(convertView, R.id.score_id);
      Button resetToZero = ViewHolder.get(convertView, R.id.reset_to_zero_id);

      final Word w = wordz.get(position);
      question.setText(w.getQuestion());
      score.setText("Score : " + w.score());
      resetToZero.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          databaseManager.resetWordScoreToZero(w);
          score.setText("Score : 0");
        }
      });
      return convertView;
    }

    @Override
    public boolean isEnabled(int position) {
      return false;
    }

    @Override
    public int getCount() {
      return wordz.size();
    }

    @Override
    public Object getItem(int position) {
      return wordz.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }
  }

  private static class ViewHolder {

    @SuppressWarnings({ "unchecked"})
    public static <T extends View> T get(View view, int id) {
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

}