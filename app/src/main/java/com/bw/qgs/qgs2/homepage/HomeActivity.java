package com.bw.qgs.qgs2.homepage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.fivefragment.FiveFragment;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.FourFragment;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.OneFragment;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.ThreeFragment;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.TwoFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ViewPager homepager;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());
        list.add(new FourFragment());
        list.add(new FiveFragment());

        homepager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        homepager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        homepager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        homepager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        homepager.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        homepager.setCurrentItem(4);
                        break;
                }
            }
        });
        homepager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private void initView() {
        homepager = (ViewPager) findViewById(R.id.homepager);
        rg = (RadioGroup) findViewById(R.id.rg);
    }
}
