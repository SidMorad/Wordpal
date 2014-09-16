package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.application.WordLab;
import mars.wordpal.domain.Word;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WordListFragment extends ListFragment {

  private ArrayList<Word> wordz;
  private static final String TAG = "WordListFragment" ;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivity().setTitle(R.string.word_list);
    wordz = WordLab.get(getActivity()).getWords();

    ArrayAdapter<Word> adapter = new ArrayAdapter<Word>(getActivity(),
        android.R.layout.simple_list_item_1, wordz);
    setListAdapter(adapter);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    Word w = (Word) getListAdapter().getItem(position);
    Log.d(TAG, w.getQuestion() + " was clicked");
  }

}