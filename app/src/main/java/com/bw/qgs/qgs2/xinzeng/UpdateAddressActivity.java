package com.bw.qgs.qgs2.xinzeng;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.myaddress.AddressActivity;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.xinzeng.bean.XiuAddUser;
import com.bw.qgs.qgs2.xinzeng.presenter.UpdateAddressPresenter;
import com.bw.qgs.qgs2.xinzeng.view.UpdateAddressView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateAddressActivity extends AppCompatActivity implements UpdateAddressView {

    @BindView(R.id.xinxiuedit1)
    EditText xinxiuedit1;
    @BindView(R.id.xinxiuedit2)
    EditText xinxiuedit2;
    @BindView(R.id.xinxiuedit3)
    EditText xinxiuedit3;
    @BindView(R.id.xinxiuedit4)
    EditText xinxiuedit4;
    @BindView(R.id.xinxiubtn)
    Button xinxiubtn;
    @BindView(R.id.xinxiuedit5)
    EditText xinxiuedit5;
    private UpdateAddressPresenter mUpdateAddressPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        ButterKnife.bind(this);
        mUpdateAddressPresenter = new UpdateAddressPresenter(this);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        String realName = intent.getStringExtra("realName");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");
        String zipCode = intent.getStringExtra("zipCode");
        xinxiuedit1.setText(realName);
        xinxiuedit2.setText(phone);
        xinxiuedit3.setText(address);
        xinxiuedit4.setText(zipCode);
        xinxiuedit5.setText(id+"");
    }

    @OnClick(R.id.xinxiubtn)
    public void onViewClicked() {
        String string1 = xinxiuedit1.getText().toString();
        String string2 = xinxiuedit2.getText().toString();
        String string3 = xinxiuedit3.getText().toString();
        String string4 = xinxiuedit4.getText().toString();
        String string5 = xinxiuedit5.getText().toString();
        int anInt = Integer.parseInt(string5);
        xinxiuedit1.setText(string1);
        xinxiuedit2.setText(string2);
        xinxiuedit3.setText(string3);
        xinxiuedit4.setText(string4);
        xinxiuedit5.setText(anInt+"");
        mUpdateAddressPresenter.addresspre(UrlUtil.UPDATAADDRESS,anInt,string1,string2,string3,string4);
        Intent intent = new Intent(UpdateAddressActivity.this,AddressActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onUpAddSuccess(String result) {
        Gson gson = new Gson();
        XiuAddUser xiuAddUser = gson.fromJson(result, XiuAddUser.class);
        String message = xiuAddUser.getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpAddFailer(String msg) {

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
