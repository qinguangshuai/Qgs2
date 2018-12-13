package com.bw.qgs.qgs2.homepage.fragment.threefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.qgs.qgs2.Contexton;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.ChuanZhiBean;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.adapter.ThreeFragmentAdapter;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.presenter.ThreeFragmentPresenter;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.user.ThreeFragmentUser;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.view.ThreeFragmentView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ThreeFragment extends Fragment implements ThreeFragmentView {

    @BindView(R.id.threerecycle)
    RecyclerView threerecycle;
    @BindView(R.id.threecheck)
    CheckBox threecheck;
    @BindView(R.id.threetextmoney)
    TextView threetextmoney;
    @BindView(R.id.threecheckbtn)
    Button threecheckbtn;
    Unbinder unbinder;
    private ThreeFragmentPresenter mThreeFragmentPresenter;
    private List<ThreeFragmentUser.ResultBean> mResult1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        unbinder = ButterKnife.bind(this, view);
        mThreeFragmentPresenter = new ThreeFragmentPresenter(this);
        mThreeFragmentPresenter.threeshop(UrlUtil.THREESHOPCAR);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        return view;
    }

    @Subscribe
    public void GetData(ChuanZhiBean chuanZhiBean) {
        if (chuanZhiBean.getId() == Contexton.CHAUNZHI) {
            mThreeFragmentPresenter = new ThreeFragmentPresenter(this);
            mThreeFragmentPresenter.threeshop(UrlUtil.THREESHOPCAR);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onThreeSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        threerecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        ThreeFragmentUser threeFragmentUser = gson.fromJson(result, ThreeFragmentUser.class);
        mResult1 = threeFragmentUser.getResult();
        ThreeFragmentAdapter threeFragmentAdapter = new ThreeFragmentAdapter(getActivity(), mResult1);
        threerecycle.setAdapter(threeFragmentAdapter);
    }

    @Override
    public void onThreeFailer(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.threecheck, R.id.threecheckbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.threecheck:
                break;
            case R.id.threecheckbtn:
                break;
        }
    }
}
