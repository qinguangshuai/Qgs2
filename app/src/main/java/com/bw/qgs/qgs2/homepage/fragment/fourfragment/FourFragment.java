package com.bw.qgs.qgs2.homepage.fragment.fourfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding.DingFragment;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.finish.FinishFragment;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.fu.FuFragment;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ping.PingFragment;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.shou.ShouFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FourFragment extends Fragment {

    @BindView(R.id.fourrg)
    RadioGroup fourrg;
    @BindView(R.id.fourpager)
    ViewPager fourpager;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        unbinder = ButterKnife.bind(this, view);
        final ArrayList<Fragment> list = new ArrayList<>();
        list.add(new DingFragment());
        list.add(new FuFragment());
        list.add(new ShouFragment());
        list.add(new PingFragment());
        list.add(new FinishFragment());
        fourpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                fourrg.check(fourrg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        fourrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.fourbtn1:
                        fourpager.setCurrentItem(0);
                        break;
                    case R.id.fourbtn2:
                        fourpager.setCurrentItem(1);
                        break;
                    case R.id.fourbtn3:
                        fourpager.setCurrentItem(2);
                        break;
                    case R.id.fourbtn4:
                        fourpager.setCurrentItem(3);
                        break;
                    case R.id.fourbtn5:
                        fourpager.setCurrentItem(4);
                        break;
                }
            }
        });
        fourpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
