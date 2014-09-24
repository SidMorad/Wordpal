package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WordListFragment extends ListFragment {

  private static final String TAG = "WordListFragment" ;
  private ArrayList<Word> wordz;
  private WordAdapter wordAdapter;
  private WordCollection wordCollection;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.word_list);
    wordCollection = WordCollectionsInMemory.wordTrainerLesson1();
    wordz = new ArrayList<Word>();
    wordz.add(wordCollection.nextOne());

    wordAdapter = new WordAdapter(wordz, R.layout.wordlist_item);
    setListAdapter(wordAdapter);
  }

  @Override
  public void onResume() {
    super.onResume();
    ((WordAdapter) getListAdapter()).notifyDataSetChanged();
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    Word w = (Word) getListAdapter().getItem(position);
    // start activity
    Intent i = new Intent(getActivity(), WordActivity.class);
    i.putExtra(WordFragment.EXTRA_WORD_ID, w.getQuestion());
    startActivity(i);
  }

  private class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(ArrayList<Word> wordz, int resourceId) {
      super(getActivity(), resourceId, wordz);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
      // If we weren't given a view, inflate one
      if (convertView == null) {
        convertView =
          getActivity().
          getLayoutInflater().
          inflate(R.layout.wordlist_item, null);

      // Configure the view for this wordz
      final Word w = getItem(position);
      TextView questionTextView = (TextView) convertView.findViewById(R.id.question_id);
      questionTextView.setText(w.getQuestion());
      Button deButton = (Button) convertView.findViewById(R.id.de_id);
      deButton.setTag(w.getAnswerDe());
      Button faButton = (Button) convertView.findViewById(R.id.fa_id);
      faButton.setTag(w.getAnswerFa());

      Button iKnowBtn = (Button) convertView.findViewById(R.id.i_know_id);
      iKnowBtn.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
          Word nextOne = wordCollection.nextOne();
          if (nextOne == null) {
            Toast.makeText(getActivity(), "One round is done.", Toast.LENGTH_LONG).show();
          } else {
            wordz.clear();
            wordz.add(nextOne);
            // Note wordAdapter.notifyDataSetChanged(); didn't work as expected, so we use next line
            setListAdapter(wordAdapter);
            Log.d(TAG, "WordAdapter size " + wordAdapter.getCount());
          }
        }
      });
      }
      return convertView;
    }
  }

}