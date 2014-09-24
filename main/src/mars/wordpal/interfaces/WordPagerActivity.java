package mars.wordpal.interfaces;

import java.util.ArrayList;

import mars.wordpal.R;
import mars.wordpal.domain.model.Word;
import mars.wordpal.domain.model.WordCollection;
import mars.wordpal.infrastructure.WordCollectionsInMemory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WordPagerActivity extends FragmentActivity {

  private ViewPager viewPager;
  private ArrayList<Word> wordz;
  private WordCollection wordCollection;

  @Override
  protected void onCreate(Bundle arg0) {
    super.onCreate(arg0);
    viewPager = new ViewPager(this);
    viewPager.setId(R.id.viewPager);
    setContentView(viewPager);
    wordCollection = WordCollectionsInMemory.wordTrainerLesson1();
    wordz = new ArrayList<Word>();
    wordz.addAll(wordCollection.wordz());
    FragmentManager fm = getSupportFragmentManager();
    viewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
      @Override
      public int getCount() {
        return wordz.size();
      }
      
      @Override
      public Fragment getItem(int position) {
        return WordFragment.newInstance(wordz.get(position).getQuestion());
      }
    });
    String questionId = getIntent().getStringExtra(WordFragment.EXTRA_WORD_ID);
    for (int i = 0; i < wordz.size(); i++) {
      if (wordz.get(i).getQuestion().equals(questionId)) {
        viewPager.setCurrentItem(i);
      }
    }
    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrollStateChanged(int state) {
      }
      @Override
      public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {
      }
      @Override
      public void onPageSelected(int pos) {
        Word word = wordz.get(pos);
        if (word.getQuestion() != null) {
          setTitle(word.getQuestion());
        }
      }
    });
  }

  public void deToast(View v)  {
    ((TextView) findViewById(R.id.answer_id)).setText((String) v.getTag());
    ((Button) findViewById(R.id.not_sure_id)).
      setBackgroundResource(R.drawable.button_notsure_forsure);
  }

  public void faToast(View v)  {
    ((TextView) findViewById(R.id.answer_id)).setText((String) v.getTag());
    ((Button) findViewById(R.id.not_sure_id)).
    setBackgroundResource(R.drawable.button_notsure_forsure);
  }

  public void iKnow(View v) {
    Toast.makeText(this, v.getTag() + "+1", Toast.LENGTH_SHORT).show();
  }

  public void notSure(View v) {
    Toast.makeText(this, v.getTag() + "-1", Toast.LENGTH_SHORT).show();
  }

}