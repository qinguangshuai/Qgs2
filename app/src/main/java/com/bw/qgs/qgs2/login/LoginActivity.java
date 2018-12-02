package com.bw.qgs.qgs2.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.comment.CusTomComment;
import com.bw.qgs.qgs2.homepage.HomeActivity;
import com.bw.qgs.qgs2.login.bean.LoginUser;
import com.bw.qgs.qgs2.login.presenter.LoginPresenter;
import com.bw.qgs.qgs2.login.view.RegisnView;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.url.UrlUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements RegisnView {

    @BindView(R.id.edit1)
    EditText edit1;
    @BindView(R.id.edit2)
    EditText edit2;
    @BindView(R.id.remember)
    CheckBox remember;
    @BindView(R.id.registered)
    TextView registered;
    @BindView(R.id.relativelayout)
    RelativeLayout relativelayout;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.visible)
    ImageView visible;
    @BindView(R.id.re)
    RelativeLayout re;
    private LoginPresenter mLoginPresenter;
    private String phone;
    private String pwd;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private Boolean showPassword = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
        initData();
    }

    private void initData() {
        sp = getSharedPreferences("login", MODE_PRIVATE);
        edit = sp.edit();
        if (sp.getBoolean("remember", false)) {
            edit1.setText(sp.getString("phone", phone));
            edit2.setText(sp.getString("pwd", pwd));
            remember.setChecked(true);
        }
    }

    @OnClick({R.id.remember, R.id.registered, R.id.login})
    public void onViewClicked(View view) {
        phone = edit1.getText().toString().trim();
        pwd = edit2.getText().toString().trim();
        switch (view.getId()) {
            case R.id.remember:
                break;
            case R.id.registered:
                startActivity(new Intent(LoginActivity.this, ReginActivity.class));
                break;
            case R.id.login:
                if (remember.isChecked()) {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("phone", phone);
                    edit.putString("pwd", pwd);
                    edit.putBoolean("remember", remember.isChecked());
                    edit.commit();
                }else{
                    edit.putString("phone", "");
                    edit.putString("pwd", "");
                    edit.putBoolean("remember", remember.isChecked());
                    edit.commit();
                }
                mLoginPresenter.login(UrlUtil.LOGIN1, phone + UrlUtil.LOGIN2, pwd, new BaseRequest());
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                Class<LoginUser> loginUserClass = LoginUser.class;
                CusTomComment annotation = loginUserClass.getAnnotation(CusTomComment.class);
                String name = annotation.userName();
                String pwd1 = annotation.passWord();
                if(name.equals(phone)){
                    Toast.makeText(getApplicationContext(),"姓名没毛病",Toast.LENGTH_SHORT).show();
                    if(pwd1.equals(pwd)){
                        Toast.makeText(getApplicationContext(),"密码没毛病",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"哪里出了错呢",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResignSuccess(String result) {

    }

    @Override
    public void onFailer(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResignFailer(String msg) {

    }

    @OnClick(R.id.visible)
    public void onViewClicked() {
        if (edit2.getInputType() == 129) {// 显示密码
            edit2.setInputType(128);
        } else {// 隐藏密码
            edit2.setInputType(129);
        }
    }
}
