package com.bw.qgs.qgs2.xinzeng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.xinzeng.bean.XinZeng;
import com.bw.qgs.qgs2.xinzeng.presenter.XinZengPresenter;
import com.bw.qgs.qgs2.xinzeng.view.XinZengView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XinZengActivity extends AppCompatActivity implements XinZengView {

    @BindView(R.id.xinedit1)
    EditText xinedit1;
    @BindView(R.id.xinedit2)
    EditText xinedit2;
    @BindView(R.id.xinedit3)
    EditText xinedit3;
    @BindView(R.id.xinedit4)
    EditText xinedit4;
    @BindView(R.id.xinbtn)
    Button xinbtn;
    private XinZengPresenter mXinZengPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_zeng);
        ButterKnife.bind(this);
        mXinZengPresenter = new XinZengPresenter(this);
    }

    @OnClick(R.id.xinbtn)
    public void onViewClicked() {
        String s1 = xinedit1.getText().toString();
        String s2 = xinedit2.getText().toString();
        String s3 = xinedit3.getText().toString();
        String s4 = xinedit4.getText().toString();
        mXinZengPresenter.xin(UrlUtil.XINZENG1,s1+UrlUtil.XINZENG2,s2+UrlUtil.XINZENG3,s3+UrlUtil.XINZENG4,s4,new BaseRequest());
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailer(String msg) {

    }
}
