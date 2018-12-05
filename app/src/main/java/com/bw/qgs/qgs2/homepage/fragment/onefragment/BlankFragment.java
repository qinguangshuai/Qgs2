package com.bw.qgs.qgs2.homepage.fragment.onefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.qgs.qgs2.R;

public class BlankFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        OneFragment oneFragment = new OneFragment();
        fragmentTransaction.add(R.id.fragmentlayout,oneFragment);
        fragmentTransaction.commit();
        return view;
    }

}
