package com.bw.qgs.qgs2.homepage.fragment.particulars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.Contexton;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.particulars.adapter.GoodsParticularsAdapter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.ChuanZhiBean;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.bw.qgs.qgs2.homepage.fragment.particulars.presenter.GoodsParticularsPresenter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.shop.ShopPresenter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.shop.ShopUser;
import com.bw.qgs.qgs2.homepage.fragment.particulars.view.GoodsParticularView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class GoodsParticularsActivity extends AppCompatActivity implements GoodsParticularView {

    private GoodsParticularsPresenter mGoodsParticularsPresenter;
    private RecyclerView recycle;
    private GoodsParticularsAdapter mGoodsParticularsAdapter;
    private ShopPresenter mShopPresenter;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_particulars);
        recycle = findViewById(R.id.goodspartrecycle);
        back = findViewById(R.id.back);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);
        mGoodsParticularsPresenter = new GoodsParticularsPresenter(this);
        mGoodsParticularsPresenter.par(UrlUtil.GOODSPARTICU+id);
        mGoodsParticularsAdapter = new GoodsParticularsAdapter(getApplicationContext(),null);
        mShopPresenter = new ShopPresenter(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onGoodsParticuSuccess(final Particulars.ResultBean resultBean) {
        LinearLayoutManager lineatlayoutmanager = new LinearLayoutManager(this);
        recycle.setLayoutManager(lineatlayoutmanager);
        mGoodsParticularsAdapter.setResultBean(resultBean);
        mGoodsParticularsAdapter.setHttpAdd(new GoodsParticularsAdapter.HttpAdd() {
            @Override
            public void getAdd(View v, int position) {
                //同步购物车
                ShopUser shopUser = new ShopUser();
                shopUser.setCommodityId(resultBean.getCommodityId());
                shopUser.setCount(1);
                List<ShopUser> list = new ArrayList<>();
                list.add(shopUser);
                Gson gson = new Gson();
                String s = gson.toJson(list);
                mShopPresenter.shop(UrlUtil.SHOPCAR,s);
                EventBus.getDefault().post(new ChuanZhiBean(Contexton.CHAUNZHI));
            }
        });
        recycle.setAdapter(mGoodsParticularsAdapter);
    }

    @Override
    public void onShopSuccess(String result) {
        Gson gson = new Gson();
        ShopUser shopUser = gson.fromJson(result, ShopUser.class);
        int commodityId = shopUser.getCommodityId();
        Toast.makeText(this,commodityId+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGoodsParticuFailer(String msg) {

    }
}
