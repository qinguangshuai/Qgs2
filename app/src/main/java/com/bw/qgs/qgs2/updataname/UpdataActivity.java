package com.bw.qgs.qgs2.updataname;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.qgs.qgs2.MainActivity;
import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.updataname.bean.UpdataUser;
import com.bw.qgs.qgs2.updataname.presenter.UpdatePresenter;
import com.bw.qgs.qgs2.updataname.view.UpdateView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.google.gson.Gson;

public class UpdataActivity extends AppCompatActivity implements UpdateView {

    private UpdatePresenter mUpdatePresenter;
    private Button btn;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata);
        btn = findViewById(R.id.updatebtn);
        name = findViewById(R.id.updatename);
        mUpdatePresenter = new UpdatePresenter(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = name.getText().toString();
                mUpdatePresenter.putUpdate(UrlUtil.NAME,string);
                Intent intent = new Intent(UpdataActivity.this,MainActivity.class);
                intent.putExtra("name",string);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onUpdateSuccess(String result) {
        Gson gson = new Gson();
        UpdataUser updataUser = gson.fromJson(result, UpdataUser.class);
        String message = updataUser.getMessage();
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpdateFailer(String msg) {

    }

    float x1, x2;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /*if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x2 = event.getX();
            if (x2 - x1 > 200) {
                finish();
            }
        }*/
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            if (x2 - x1 > 100) {
                finish();
            }
        }
        return super.onTouchEvent(event);

    }
}
