package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity implements CounterInterface {

    private ViewPager2 viewPager;
    private int currentCounter;
    private TextView counterTextView;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        counterTextView = findViewById(R.id.counter_textview);
        tabLayout = findViewById(R.id.tablayout);

        counterTextView.setText(getString(R.string.counter_text, currentCounter));

        final FragmentOne fragmentOne = FragmentOne.newInstance();
        final FragmentTwo fragmentTwo = FragmentTwo.newInstance();

        viewPager.setAdapter(new FragmentStateAdapter(this) {

            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0) {
                    return fragmentOne;
                }
                return fragmentTwo;
            }
        });

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(position == 0 ? FragmentOne.TAB_NAME : FragmentTwo.TAB_NAME);
            }
        });
        tabLayoutMediator.attach();
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
