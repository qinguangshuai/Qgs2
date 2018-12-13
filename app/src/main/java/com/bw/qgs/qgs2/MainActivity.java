package com.bw.qgs.qgs2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.updataname.UpdataActivity;
import com.bw.qgs.qgs2.updataname.UpdatePwdActivity;

public class MainActivity extends AppCompatActivity {

    private TextView nic, mima,nicheng;
    private ImageView touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nic = findViewById(R.id.nicheng);
        mima = findViewById(R.id.mima);
        touxiang = findViewById(R.id.touxiang);
        nicheng = findViewById(R.id.nicheng);
        Intent intent = getIntent();
        String sistem = intent.getStringExtra("sistem");
        nic.setText(sistem);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String pwd = sp.getString("pwd", "");
        String headPic = sp.getString("headPic", "");
        Uri uri = Uri.parse(headPic);
        touxiang.setImageURI(uri);
        String nickName = sp.getString("nickName", "");
        nicheng.setText(nickName);
        mima.setText(pwd);
        nicheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdataActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdatePwdActivity.class);
                startActivity(intent);
                finish();
            }
        });
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
