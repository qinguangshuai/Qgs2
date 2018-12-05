package com.bw.qgs.qgs2.homepage.fragment.onefragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.OneFragAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.ShoeAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.ShoeUser;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.OneFragmentOnePresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.ShoePresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class OneFragment extends Fragment implements OneFragmentOneView {

    @BindView(R.id.lefticon)
    TextView lefticon;
    @BindView(R.id.righticon)
    TextView righticon;
    Unbinder unbinder;
    private XRecyclerView onefragmentrecycle;
    private OneFragmentOnePresenter mOneFragmentOnePresenter;
    private OneFragAdapter mOneFragAdapter;
    private PopupWindow pop;
    private ShoePresenter mShoePresenter;
    private ShoeUser.ResultBean mResult1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        onefragmentrecycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onefragmentrecycle.refreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onefragmentrecycle.loadMoreComplete();
                    }
                }, 2000);
            }
        });
    }

    private void initView(View view) {
        onefragmentrecycle = view.findViewById(R.id.onefragmentrecycle);

    }

    private void initData() {
        mOneFragmentOnePresenter = new OneFragmentOnePresenter(this);
        mOneFragmentOnePresenter.one(UrlUtil.ONE);
        mOneFragAdapter = new OneFragAdapter(getActivity(), null);
        mShoePresenter = new ShoePresenter(this);
        mShoePresenter.shoe(UrlUtil.SHOE);
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(TwoAdapterBean.ResultBean resultBeans) {
        LinearLayoutManager lineatlayoutmanager = new LinearLayoutManager(getActivity());
        onefragmentrecycle.setLayoutManager(lineatlayoutmanager);
        mOneFragAdapter.setdata(resultBeans);
        mOneFragAdapter.setHttpOnClick(new OneFragAdapter.HttpOnClick() {
            @Override
            public void click(View view, int position) {
                Toast.makeText(getActivity(),"222",Toast.LENGTH_SHORT).show();
            }
        });
        onefragmentrecycle.setAdapter(mOneFragAdapter);
    }

    @Override
    public void onShopSuccess(String result) {
        Gson gson = new Gson();
        ShoeUser shoeUser = gson.fromJson(result, ShoeUser.class);
        mResult1 = shoeUser.getResult();
        ShoeAdapter shoeAdapter = new ShoeAdapter(getActivity(),mResult1);
        //onefragmentrecycle1.setAdapter(shoeAdapter);
    }

    @Override
    public void onFailer(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.lefticon, R.id.righticon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lefticon:
                View popView = View.inflate(getActivity(), R.layout.pop_item, null);
                pop = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.showAsDropDown(view, 0, 0);
                break;
            case R.id.righticon:
                break;
        }
    }
}
