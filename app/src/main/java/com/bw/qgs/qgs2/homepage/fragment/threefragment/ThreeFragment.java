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
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bw.qgs.qgs2.Contexton;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.custom.AddSub;
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
    private ThreeFragmentAdapter mThreeFragmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mThreeFragmentPresenter = new ThreeFragmentPresenter(this);
        mThreeFragmentPresenter.threeshop(UrlUtil.THREESHOPCAR);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        unbinder = ButterKnife.bind(this, view);
        threecheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setCheckAll();
                getTotal();
            }
        });
        return view;
    }

    public void getTotal(){
        int total = 0;
        List<ThreeFragmentUser.ResultBean> result1 = mThreeFragmentAdapter.getResult1();
        for (int i = 0;i<result1.size();i++){
            boolean checked = result1.get(i).isChecked();
            if(checked){
                double price = result1.get(i).getPrice();
                total+=price*result1.get(i).getCount();
            }
        }
        threetextmoney.setText("$"+total);
    }

    public void setCheckAll(){
        List<ThreeFragmentUser.ResultBean> result1 = mThreeFragmentAdapter.getResult1();
        for (int i = 0;i<result1.size();i++){
            result1.get(i).setChecked(threecheck.isChecked());
        }
        mThreeFragmentAdapter.notifyDataSetChanged();
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
        mThreeFragmentAdapter = new ThreeFragmentAdapter(getActivity(), mResult1);
        mThreeFragmentAdapter.setCheckDan(new ThreeFragmentAdapter.checkDan() {
            @Override
            public void getId(int position) {
                boolean checked = mResult1.get(position).isChecked();
                if (checked){
                    mResult1.get(position).setChecked(false);
                    getTotal();
                }else{
                    mResult1.get(position).setChecked(true);
                    getTotal();
                }
            }
        });
        threerecycle.setAdapter(mThreeFragmentAdapter);
        initShopCartChange();
    }

    @Override
    public void onThreeFailer(String msg) {

    }

    private void initShopCartChange(){
        mThreeFragmentAdapter.setOnNumChangedListener(new AddSub.OnNumChangedListener() {
            @Override
            public void onNumChange(View view, int curNum) {
                getTotal();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.threecheckbtn)
    public void onViewClicked() {
        
    }
}
