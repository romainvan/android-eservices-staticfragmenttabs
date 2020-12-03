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

public class MainActivity extends FragmentActivity implements MonInterface {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private int currentCounter;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViewPagerAndTabs();
    }

    //TODO fill the method to get view references and initialize viewpager to display our fragments
    private void setupViewPagerAndTabs() {
        viewPager = findViewById(R.id.tab_viewpager);
        tabLayout = findViewById(R.id.tablayout);
        counterTextView = findViewById(R.id.counter_textview);
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
        //TODO we want two fragments with layouts : fragment_one, fragment_two.
        final FragmentOne fragmentOne = new FragmentOne();
        final FragmentTwo fragmentTwo = new FragmentTwo();
        //TODO set adapter to viewpager and handle tragment change inside
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @Override
            public int getItemCount() {
                return 2;
            }

            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if(position==0){
                    return fragmentOne;
                }
                else{

                    return fragmentTwo;
                }
            }

        });

        //TabLayoutMediator tabLayoutMediator...
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->  tab.setText(position == 0 ? FragmentOne.TAB_NAME : FragmentTwo.TAB_NAME)
        ).attach();

    }

    @Override
    public void plus() {
        currentCounter++;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    @Override
    public void moins() {
        currentCounter--;
        counterTextView.setText(getString(R.string.counter_text, currentCounter));
    }

    //TODO : increment and decrement counter, use the already provided String ressource (see strings.xml)
}
