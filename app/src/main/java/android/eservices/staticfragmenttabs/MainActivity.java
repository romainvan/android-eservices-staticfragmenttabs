package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements CounterInterface {

    private ViewPager viewPager;
    private int currentCounter;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        counterTextView = findViewById(R.id.counter_textview);

        counterTextView.setText(getString(R.string.counter_text, currentCounter));

        final FragmentOne fragmentOne = FragmentOne.newInstance();
        final FragmentTwo fragmentTwo = FragmentTwo.newInstance();

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return fragmentOne;
                }
                return fragmentTwo;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return FragmentOne.TAB_NAME;
                }
                return FragmentTwo.TAB_NAME;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
    }

    @Override
    public void incrementCounter() {
        currentCounter++;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    @Override
    public void decrementCounter() {
        currentCounter--;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }
}
