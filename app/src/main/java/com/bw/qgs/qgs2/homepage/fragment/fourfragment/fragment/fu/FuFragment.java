package com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.fu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding.QuanAdapter;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding.QuanUser;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.OneDingUser;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.DingPresenter;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class FuFragment extends Fragment implements QuanFuView {

    private RecyclerView furecycle;
    private QuanFuPresenter mQuanFuPresenter;
    private List<QuanUser.OrderListBean> mOrderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fu, container, false);
        furecycle = view.findViewById(R.id.furecycle);
        mQuanFuPresenter = new QuanFuPresenter(this);
        mQuanFuPresenter.getQueryFu(UrlUtil.QUERYFU);
        return view;
    }

    @Override
    public void onQuanFuSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        furecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        QuanUser quanUser = gson.fromJson(result, QuanUser.class);
        mOrderList = quanUser.getOrderList();
        QuanAdapter quanAdapter = new QuanAdapter(getActivity(),mOrderList);
        furecycle.setAdapter(quanAdapter);
    }

    @Override
    public void onQuanFuFailer(String msg) {

    }
}
