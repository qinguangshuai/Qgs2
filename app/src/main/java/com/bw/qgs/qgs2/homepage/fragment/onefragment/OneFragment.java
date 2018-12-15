package com.bw.qgs.qgs2.homepage.fragment.onefragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.OneDianAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.OneFragAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.QueryAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.QueryGoodsAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.YiAdapter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.BannerUser;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.OneDianBean;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.QueryGoods;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.QueryUser;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.YiJi;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.BannerPresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.OneDianPresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.OneFragmentOnePresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.QueryPresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter.YiPresenter;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;
import com.bw.qgs.qgs2.homepage.fragment.particulars.GoodsParticularsActivity;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.List;

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
    private XRecyclerView onefragmentrecycle,onefragmentrecycle1,twofragmentrecycle1;
    private OneFragmentOnePresenter mOneFragmentOnePresenter;
    private OneFragAdapter mOneFragAdapter;
    private PopupWindow pop;
    private LinearLayout recycleone1,recycleone2;
    private BannerPresenter mBannerPresenter;
    private List<QueryGoods.ResultBean> mGoodsResult;
    private TextView lefticon1,righticon1;
    float x1, x2;
    private List<OneDianBean.ResultBean> dianlist;
    private OneDianPresenter mOneDianPresenter;
    private EditText queryedit;
    private List<QueryUser.ResultBean> mResultBeans;
    private QueryPresenter mQueryPresenter;
    private RecyclerView pop1recycle;
    private List<YiJi.ResultBean> mResult1;
    private YiPresenter mYiPresenter;

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
        onefragmentrecycle1 = view.findViewById(R.id.onefragmentrecycle1);
        twofragmentrecycle1 = view.findViewById(R.id.twofragmentrecycle1);
        recycleone2 = view.findViewById(R.id.recycleone2);
        recycleone1 = view.findViewById(R.id.recycleone1);
        lefticon1 = view.findViewById(R.id.lefticon1);
        righticon1 = view.findViewById(R.id.righticon1);
        queryedit = view.findViewById(R.id.queryedit);
        //pop1recycle = view.findViewById(R.id.pop1recycle);
        initClick();
    }

    private void initClick() {
        lefticon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycleone1.setVisibility(View.VISIBLE);
                recycleone2.setVisibility(View.GONE);
            }
        });
        righticon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = queryedit.getText().toString();
                mQueryPresenter.query1(UrlUtil.QUERY+edit);
                recycleone1.setVisibility(View.GONE);
                recycleone2.setVisibility(View.GONE);
                onefragmentrecycle1.setVisibility(View.GONE);
                twofragmentrecycle1.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initData() {
        mOneFragmentOnePresenter = new OneFragmentOnePresenter(this);
        mOneFragmentOnePresenter.one(UrlUtil.ONE);
        mOneFragAdapter = new OneFragAdapter(getActivity(), null,null);
        mBannerPresenter = new BannerPresenter(this);
        mBannerPresenter.banner(UrlUtil.BANNER);
        mOneDianPresenter = new OneDianPresenter(this);
        mQueryPresenter = new QueryPresenter(this);
        mYiPresenter = new YiPresenter(this);
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
    public void onSuccess(final TwoAdapterBean.ResultBean resultBeans) {
        LinearLayoutManager lineatlayoutmanager = new LinearLayoutManager(getActivity());
        onefragmentrecycle.setLayoutManager(lineatlayoutmanager);
        mOneFragAdapter.setdata(resultBeans);
        mOneFragAdapter.setHttpOnClick(new OneFragAdapter.HttpOnClick() {
            @Override
            public void click(View view, int position) {
                recycleone2.setVisibility(View.VISIBLE);
                recycleone1.setVisibility(View.GONE);
                int id = resultBeans.getRxxp().get(0).getId();
                mOneDianPresenter.dian(UrlUtil.ONETIAO+id);
            }
        });
        mOneFragAdapter.setHttpOnClick1(new OneFragAdapter.HttpOnClick1() {
            @Override
            public void click(View view, int position) {
                recycleone2.setVisibility(View.VISIBLE);
                recycleone1.setVisibility(View.GONE);
                int id = resultBeans.getMlss().get(0).getId();
                mOneDianPresenter.dian(UrlUtil.ONETIAO+id);
            }
        });
        mOneFragAdapter.setHttpOnClick2(new OneFragAdapter.HttpOnClick2() {
            @Override
            public void click(View view, int position) {
                recycleone2.setVisibility(View.VISIBLE);
                recycleone1.setVisibility(View.GONE);
                int id = resultBeans.getPzsh().get(0).getId();
                mOneDianPresenter.dian(UrlUtil.ONETIAO+id);
            }
        });
        onefragmentrecycle.setAdapter(mOneFragAdapter);
    }

    @Override
    public void onBannerSuccess(String result) {
        Gson gson = new Gson();
        BannerUser bannerUser = gson.fromJson(result, BannerUser.class);
        List<BannerUser.ResultBean> beanList = bannerUser.getResult();
        mOneFragAdapter.setResultBean(beanList);
        //Toast.makeText(getActivity(),beanList.size()+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onQueryGoodsSuccess(String result) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        onefragmentrecycle1.setLayoutManager(gridLayoutManager);
        Gson gson = new Gson();
        QueryGoods queryGoods = gson.fromJson(result, QueryGoods.class);
        mGoodsResult = queryGoods.getResult();
        QueryGoodsAdapter queryGoodsAdapter = new QueryGoodsAdapter(getActivity(),mGoodsResult);
        onefragmentrecycle1.setAdapter(queryGoodsAdapter);
        //Toast.makeText(getActivity(),result+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOneDianSuccess(final String result) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        onefragmentrecycle1.setLayoutManager(gridLayoutManager);
        Gson gson = new Gson();
        OneDianBean oneDianBean = gson.fromJson(result, OneDianBean.class);
        dianlist = oneDianBean.getResult();
        OneDianAdapter oneDianAdapter = new OneDianAdapter(getActivity(),dianlist);
        oneDianAdapter.setClick(new OneDianAdapter.HttpClick() {
            @Override
            public void click(View view, int position) {
                int commodityId = dianlist.get(position).getCommodityId();
                mOneDianPresenter.dian(UrlUtil.ONETIAO+commodityId);
                Intent intent = new Intent(getActivity(),GoodsParticularsActivity.class);
                Toast.makeText(getActivity(),commodityId+"",Toast.LENGTH_SHORT).show();
                intent.putExtra("id",commodityId);
                startActivity(intent);
            }
        });
        onefragmentrecycle1.setAdapter(oneDianAdapter);
    }

    @Override
    public void onFailer(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    //查询
    @Override
    public void onQuerySuccess(String result) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        twofragmentrecycle1.setLayoutManager(gridLayoutManager);
        Gson gson = new Gson();
        QueryUser queryUser = gson.fromJson(result, QueryUser.class);
        mResultBeans = queryUser.getResult();
        QueryAdapter queryAdapter = new QueryAdapter(getActivity(),mResultBeans);
        twofragmentrecycle1.setAdapter(queryAdapter);
    }

    @Override
    public void onJiSuccess(String result) {
        /*GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        pop1recycle.setLayoutManager(gridLayoutManager);
        Gson gson = new Gson();
        YiJi yiJi = gson.fromJson(result, YiJi.class);
        mResult1 = yiJi.getResult();
        YiAdapter yiAdapter = new YiAdapter(getActivity(),mResult1);
        pop1recycle.setAdapter(yiAdapter);*/
    }

    @OnClick({R.id.lefticon, R.id.righticon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lefticon:
                //mYiPresenter.yi(UrlUtil.YIJI);
                View popView = View.inflate(getActivity(), R.layout.pop_item, null);
                pop = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.showAsDropDown(view, 0, 0);
                popView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(pop.isShowing()){
                            pop.dismiss();
                        }
                        return false;
                    }
                });
                break;
            case R.id.righticon:
                break;
        }
    }
}
