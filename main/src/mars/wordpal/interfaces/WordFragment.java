package mars.wordpal.interfaces;

import mars.wordpal.R;
import mars.wordpal.domain.model.Word;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class WordFragment extends Fragment {

  public static final String EXTRA_WORD_ID = "mars.wordpal.word_id";
  private Word word;
  private TextView questionTextView;
  private Button faButton;
  private Button deButton;
  private Button iKnowButton;
  private Button notSureButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    String wordId = (String) getArguments().getString(EXTRA_WORD_ID);
//    word = WordCollectionsInMemory.get(wordId);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_word, parent, false);

    questionTextView = (TextView) v.findViewById(R.id.question_id);
    questionTextView.setText(word.getQuestion());
    deButton = (Button) v.findViewById(R.id.de_id);
    faButton = (Button) v.findViewById(R.id.fa_id);
    iKnowButton = (Button) v.findViewById(R.id.i_know_id);
    notSureButton = (Button) v.findViewById(R.id.not_sure_id); 
    deButton.setTag(word.getAnswerDe());
    faButton.setTag(word.getAnswerFa());
    iKnowButton.setTag(word.getQuestion());
    notSureButton.setTag(word.getQuestion());
    return v;
  }

  public static WordFragment newInstance(String wordId) {
    Bundle args = new Bundle();
    args.putString(EXTRA_WORD_ID, wordId);
    WordFragment fragment = new WordFragment();
    fragment.setArguments(args);
    return fragment;
  }
}