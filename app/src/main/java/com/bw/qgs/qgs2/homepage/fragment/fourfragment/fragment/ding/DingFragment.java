package com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.List;

public class DingFragment extends Fragment implements QuanDingView {

    private RecyclerView recycle;
    private QuanDingPresenter mQuanDingPresenter;
    private List<QuanUser.OrderListBean> mOrderList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ding, container, false);
        recycle = view.findViewById(R.id.quandingrecycle);
        mQuanDingPresenter = new QuanDingPresenter(this);
        mQuanDingPresenter.getQuery(UrlUtil.QUERYDING);
        return view;
    }

    @Override
    public void onQuanSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        QuanUser quanUser = gson.fromJson(result, QuanUser.class);
        mOrderList = quanUser.getOrderList();
        QuanAdapter quanAdapter = new QuanAdapter(getActivity(),mOrderList);
        recycle.setAdapter(quanAdapter);
    }

    @Override
    public void onQuanFailer(String msg) {

    }
}
