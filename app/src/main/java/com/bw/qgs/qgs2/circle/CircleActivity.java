package com.bw.qgs.qgs2.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.circle.adapter.MyCicleAdapter;
import com.bw.qgs.qgs2.circle.bean.CicleUser;
import com.bw.qgs.qgs2.circle.presenter.MyCiclePresenter;
import com.bw.qgs.qgs2.circle.view.MyCicleView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.List;

public class CircleActivity extends AppCompatActivity implements MyCicleView {

    private RecyclerView circlr;
    private MyCiclePresenter mMyCiclePresenter;
    private List<CicleUser.ResultBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        circlr = findViewById(R.id.circlrrecycle);
        mMyCiclePresenter = new MyCiclePresenter(this);
        mMyCiclePresenter.cicle(UrlUtil.MYCIRCLE);
    }

    @Override
    public void onCicleCuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        circlr.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        CicleUser cicleUser = gson.fromJson(result, CicleUser.class);
        list = cicleUser.getResult();
        MyCicleAdapter myCicleAdapter = new MyCicleAdapter(getApplicationContext(),list);
        circlr.setAdapter(myCicleAdapter);
        //Toast.makeText(CircleActivity.this,result+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCicleFailer(String msg) {

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
}
