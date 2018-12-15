package com.bw.qgs.qgs2.circle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.circle.adapter.MyCicleAdapter;
import com.bw.qgs.qgs2.circle.bean.CicleUser;
import com.bw.qgs.qgs2.circle.bean.DeleteCicle;
import com.bw.qgs.qgs2.circle.presenter.MyCiclePresenter;
import com.bw.qgs.qgs2.circle.view.MyCicleView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CircleActivity extends AppCompatActivity implements MyCicleView {

    @BindView(R.id.delete)
    ImageView delete;
    private RecyclerView circlr;
    private MyCiclePresenter mMyCiclePresenter;
    private List<CicleUser.ResultBean> list;
    private MyCicleAdapter mMyCicleAdapter;
    private com.bw.qgs.qgs2.circle.DeleteCicle mDeleteCicle;
    private boolean mChecked;
    private int mCommodityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        ButterKnife.bind(this);
        circlr = findViewById(R.id.circlrrecycle);
        mMyCiclePresenter = new MyCiclePresenter(this);
        mMyCiclePresenter.cicle(UrlUtil.MYCIRCLE);
        mDeleteCicle = new com.bw.qgs.qgs2.circle.DeleteCicle(this);
    }

    @Override
    public void onCicleCuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        circlr.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        CicleUser cicleUser = gson.fromJson(result, CicleUser.class);
        list = cicleUser.getResult();
        mMyCicleAdapter = new MyCicleAdapter(getApplicationContext(), list);
        mMyCicleAdapter.setHttpDelete(new MyCicleAdapter.HttpDelete() {
            @Override
            public void getDelete(int position) {
                //删除
                mCommodityId = list.get(position).getId();
                //mMyCicleAdapter.removeId(position);
                //mDeleteCicle.getDelete(UrlUtil.DELETECICLE, mCommodityId);
                mChecked = list.get(position).isChecked();
                /*if (mChecked) {
                    list.get(position).setChecked(false);
                } else {
                    list.get(position).setChecked(true);
                }*/
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mChecked) {
                    Toast.makeText(CircleActivity.this,"失败",Toast.LENGTH_SHORT).show();
                } else {
                    mDeleteCicle.getDelete(UrlUtil.DELETECICLE, mCommodityId);
                }
            }
        });
        circlr.setAdapter(mMyCicleAdapter);
        mMyCicleAdapter.notifyDataSetChanged();
        //Toast.makeText(CircleActivity.this,result+"",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteCicleCuccess(String result) {
        Gson gson = new Gson();
        DeleteCicle deleteCicle = gson.fromJson(result, DeleteCicle.class);
        String message = deleteCicle.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCicleFailer(String msg) {

    }

    float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
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
