package com.bw.qgs.qgs2.footer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.footer.adapter.FooterAdapter;
import com.bw.qgs.qgs2.footer.bean.FooterUser;
import com.bw.qgs.qgs2.footer.presenter.FooterPresenter;
import com.bw.qgs.qgs2.footer.view.FooterView;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FooterActivity extends AppCompatActivity implements FooterView {

    private RecyclerView footerrecycle;
    private FooterPresenter mFooterPresenter;
    private List<FooterUser.ResultBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footer);
        footerrecycle = findViewById(R.id.footerrecycle);
        mFooterPresenter = new FooterPresenter(this);

        mFooterPresenter.shoe(UrlUtil.FOOTER);
        StaggeredGridLayoutManager linearLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        footerrecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onFooterSuccess(String result) {
        Gson gson = new Gson();
        FooterUser footerUser = gson.fromJson(result, FooterUser.class);
        list = footerUser.getResult();
        if (list!=null){
            FooterAdapter footerAdapter = new FooterAdapter(getApplicationContext(),list);
            footerrecycle.setAdapter(footerAdapter);
        }
        else {
            Toast.makeText(FooterActivity.this,""+footerUser.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFooterFailer(String msg) {
        Toast.makeText(getApplicationContext(),"失败",Toast.LENGTH_SHORT).show();
    }

    float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            x2 = event.getX();
            if (x2 - x1 > 200) {
                finish();
            }
        }
        /*if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            if (x2 - x1 > 100) {
                finish();
            }
        }*/
        return super.onTouchEvent(event);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mFooterPresenter.onDestory();
    }
}
