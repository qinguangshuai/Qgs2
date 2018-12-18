package com.bw.qgs.qgs2.homepage.fragment.threefragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.Contexton;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.custom.AddSub;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.ChuanZhiBean;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.adapter.ThreeFragmentAdapter;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.presenter.ThreeFragmentPresenter;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.user.ThreeFragmentUser;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.view.ThreeFragmentView;
import com.bw.qgs.qgs2.myaddress.AddressActivity;
import com.bw.qgs.qgs2.url.LogUtil;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThreeFragment extends Fragment implements ThreeFragmentView {

    @BindView(R.id.threerecycle)
    RecyclerView threerecycle;
    @BindView(R.id.threecheck)
    CheckBox threecheck;
    @BindView(R.id.threetextmoney)
    TextView threetextmoney;
    Unbinder unbinder;
    private ThreeFragmentPresenter mThreeFragmentPresenter;
    private List<ThreeFragmentUser.ResultBean> mResult1;
    private ThreeFragmentAdapter mThreeFragmentAdapter;
    private DingPresenter mDingPresenter;
    private int mCommodityId;
    private double total = 0;
    private TextView threecheckbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mThreeFragmentPresenter = new ThreeFragmentPresenter(this);
        mThreeFragmentPresenter.threeshop(UrlUtil.THREESHOPCAR);
        threecheckbtn = view.findViewById(R.id.threecheckbtn);

        unbinder = ButterKnife.bind(this, view);
        threecheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setCheckAll();
                getTotal();
            }
        });

        mDingPresenter = new DingPresenter(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        threecheckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < mResult1.size(); i++) {
                    boolean checked = mResult1.get(i).isChecked();
                    if (checked) {
                        threecheckbtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity(), AddressActivity.mId + "", Toast.LENGTH_SHORT).show();
                                OneDingUser oneDingUser = new OneDingUser();
                                oneDingUser.setCommodityId(mCommodityId);
                                oneDingUser.setAmount(1);
                                List<OneDingUser> list = new ArrayList<>();
                                list.add(oneDingUser);
                                Gson gson = new Gson();
                                String s = gson.toJson(list);
                                mDingPresenter.getDing(UrlUtil.DING, s, total, AddressActivity.mId);
                            }
                        });
                    }
                }
            }
        });
        return view;
    }

    public void getTotal() {
        List<ThreeFragmentUser.ResultBean> result1 = mThreeFragmentAdapter.getResult1();
        for (int i = 0; i < result1.size(); i++) {
            boolean checked = result1.get(i).isChecked();
            if (checked) {
                double price = result1.get(i).getPrice();
                total += price * result1.get(i).getCount();
            }
        }
        threetextmoney.setText("$" + total);
    }

    public void setCheckAll() {
        List<ThreeFragmentUser.ResultBean> result1 = mThreeFragmentAdapter.getResult1();
        for (int i = 0; i < result1.size(); i++) {
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
                //商品id  购买数量
                mCommodityId = mResult1.get(position).getCommodityId();
                boolean checked = mResult1.get(position).isChecked();
                if (checked) {
                    mResult1.get(position).setChecked(false);
                    getTotal();
                } else {
                    mResult1.get(position).setChecked(true);
                    getTotal();
                }
            }
        });
        threerecycle.setAdapter(mThreeFragmentAdapter);
        initShopCartChange();
    }

    @Override
    public void onDingSuccess(String result) {
        Gson gson = new Gson();
        OneDingUser oneDingUser = gson.fromJson(result, OneDingUser.class);
        int commodityId = oneDingUser.getCommodityId();
        Toast.makeText(getActivity(), "" + commodityId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onThreeFailer(String msg) {

    }

    private void initShopCartChange() {
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
}
