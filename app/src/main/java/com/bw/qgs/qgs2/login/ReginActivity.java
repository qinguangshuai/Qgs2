package com.bw.qgs.qgs2.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.login.presenter.ReginPresenter;
import com.bw.qgs.qgs2.login.view.RegisnView;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.url.UrlUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReginActivity extends AppCompatActivity implements RegisnView {

    @BindView(R.id.zhanghao)
    EditText zhanghao;
    @BindView(R.id.mima)
    EditText mima;
    @BindView(R.id.regin)
    Button regin;
    private String phone;
    private String pwd;
    private ReginPresenter mReginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regin);
        ButterKnife.bind(this);
        mReginPresenter = new ReginPresenter(this);
        findViewById(R.id.hidden).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mima.getInputType() == 129) {// 显示密码
                    mima.setInputType(128);
                } else {// 隐藏密码
                    mima.setInputType(129);
                }
            }
        });
        findViewById(R.id.deng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReginActivity.this,LoginActivity.class));
            }
        });
    }

    @OnClick(R.id.regin)
    public void onViewClicked() {
        phone = zhanghao.getText().toString().trim();
        pwd = mima.getText().toString().trim();
        mReginPresenter.regin(UrlUtil.REGIN1, phone +UrlUtil.REGIN2, pwd,new BaseRequest());
    }

    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onResignSuccess(String result) {
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailer(String msg) {

    }

    @Override
    public void onResignFailer(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
