package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.application.WordLab;
import mars.wordpal.domain.Word;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class WordListFragment extends ListFragment {

  private ArrayList<Word> wordz;
//  private static final String TAG = "WordListFragment" ;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.word_list);
    wordz = WordLab.get(getActivity()).getWords();

    ArrayAdapter<Word> adapter = new WordAdapter(wordz, R.id.question_id);
    setListAdapter(adapter);
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
    public View getView(int position, View convertView, ViewGroup parent) {
      // If we weren't given a view, inflate one
      if (convertView == null) {
        convertView =
          getActivity().
          getLayoutInflater().
          inflate(R.layout.wordlist_item, null);

      // Configure the view for this wordz
      Word w = getItem(position);
      TextView questionTextView = (TextView) convertView.findViewById(R.id.question_id);
      questionTextView.setText(w.getQuestion());
      Button deButton = (Button) convertView.findViewById(R.id.de_id);
      deButton.setTag(w.getAnswerDe());
      Button faButton = (Button) convertView.findViewById(R.id.fa_id);
      faButton.setTag(w.getAnswerFa());
      }
      return convertView;
    }
  }

}