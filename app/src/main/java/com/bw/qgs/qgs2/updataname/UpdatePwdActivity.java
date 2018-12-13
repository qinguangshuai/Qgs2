package com.bw.qgs.qgs2.updataname;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.updataname.bean.UpdataUser;
import com.bw.qgs.qgs2.updataname.presenter.UpdatePwdPresenter;
import com.bw.qgs.qgs2.updataname.view.UpdatePwdView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdatePwdActivity extends AppCompatActivity implements UpdatePwdView {

    @BindView(R.id.updatepwdname1)
    EditText updatepwdname1;
    @BindView(R.id.updatepwdname2)
    EditText updatepwdname2;
    @BindView(R.id.updatepwdbtn)
    Button updatepwdbtn;
    private UpdatePwdPresenter mUpdatePwdPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        ButterKnife.bind(this);
        mUpdatePwdPresenter = new UpdatePwdPresenter(this);
    }

    @OnClick(R.id.updatepwdbtn)
    public void onViewClicked() {
        String string1 = updatepwdname1.getText().toString();
        String string2 = updatepwdname2.getText().toString();
        mUpdatePwdPresenter.putXiuPwdMethod(UrlUtil.PWD,string1,string2);
    }

    @Override
    public void onUpdatePwdSuccess(String result) {
        Gson gson = new Gson();
        UpdataUser updataUser = gson.fromJson(result, UpdataUser.class);
        String message = updataUser.getMessage();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdatePwdFailer(String msg) {

    }
}
