package com.bw.qgs.qgs2.homepage.fragment.particulars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.particulars.adapter.GoodsParticularsAdapter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.bw.qgs.qgs2.homepage.fragment.particulars.presenter.GoodsParticularsPresenter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.view.GoodsParticularView;
import com.bw.qgs.qgs2.url.UrlUtil;

public class GoodsParticularsActivity extends AppCompatActivity implements GoodsParticularView {

    private GoodsParticularsPresenter mGoodsParticularsPresenter;
    private RecyclerView recycle;
    private GoodsParticularsAdapter mGoodsParticularsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_particulars);
        recycle = findViewById(R.id.goodspartrecycle);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mGoodsParticularsPresenter = new GoodsParticularsPresenter(this);
        mGoodsParticularsPresenter.par(UrlUtil.GOODSPARTICU+id);
        mGoodsParticularsAdapter = new GoodsParticularsAdapter(getApplicationContext(),null);
    }

    @Override
    public void onGoodsParticuSuccess(Particulars.ResultBean resultBean) {
        LinearLayoutManager lineatlayoutmanager = new LinearLayoutManager(this);
        recycle.setLayoutManager(lineatlayoutmanager);
        mGoodsParticularsAdapter.setResultBean(resultBean);
        recycle.setAdapter(mGoodsParticularsAdapter);
    }

    @Override
    public void onGoodsParticuFailer(String msg) {

    }
}
