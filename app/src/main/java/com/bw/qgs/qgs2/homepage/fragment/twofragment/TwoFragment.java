package com.bw.qgs.qgs2.homepage.fragment.twofragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.adapter.TwoFragmentAdapter;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.bean.TwoFragmentUser;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.presenter.TwoFragmentPresenter;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.view.TwoFragmentView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.List;

public class TwoFragment extends Fragment implements TwoFragmentView {

    private TwoFragmentPresenter mTwoFragmentPresenter;
    private RecyclerView xrecycle;
    private List<TwoFragmentUser.ResultBean> mResult1;
    private ZanPresenter mZanPresenter;
    private CancleZanPresenter mCancleZanPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        xrecycle = view.findViewById(R.id.twofragmentxrecycle);
        mTwoFragmentPresenter = new TwoFragmentPresenter(this);
        mTwoFragmentPresenter.cicle(UrlUtil.CICLE);
        mZanPresenter = new ZanPresenter(this);
        mCancleZanPresenter = new CancleZanPresenter(this);
        ((DefaultItemAnimator)xrecycle.getItemAnimator()).setSupportsChangeAnimations(true);
        return view;
    }

    @Override
    public void onSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        xrecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        TwoFragmentUser twoFragmentUser = gson.fromJson(result, TwoFragmentUser.class);
        mResult1 = twoFragmentUser.getResult();
        TwoFragmentAdapter twoFragmentAdapter = new TwoFragmentAdapter(getActivity(), mResult1);
        twoFragmentAdapter.setHttpZan(new TwoFragmentAdapter.HttpZan() {
            @Override
            public void getZan(View v, int position) {
               int whetherGreat = mResult1.get(position).getWhetherGreat();

                if (whetherGreat == 2) {

                 //   mCancleZanPresenter.deletezan(UrlUtil.CANCLEZAN, mResult1.get(position).getId());
                }else if (whetherGreat == 1){
                //    mZanPresenter.postZanMethod(UrlUtil.ZAN, mResult1.get(position).getId());
                }
            }
        });
        xrecycle.setAdapter(twoFragmentAdapter);
    }

    @Override
    public void onZanSuccess(String result) {
        Gson gson = new Gson();
        ZanUser zanUser = gson.fromJson(result, ZanUser.class);
        String status = zanUser.getStatus();
        if (status.equals("0000")) {
            Toast.makeText(getActivity(), "点赞成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCancleZanSuccess(String result) {
        Gson gson = new Gson();
        ZanUser zanUser = gson.fromJson(result, ZanUser.class);
        String status = zanUser.getStatus();
        if (status.equals("0000")) {
            Toast.makeText(getActivity(), "取消点赞成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(),"失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailer(String msg) {

    }
}
