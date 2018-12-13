package com.bw.qgs.qgs2.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;

/**
 * date:2018/12/13    20:44
 * author:秦广帅(Lenovo)
 * fileName:AddSub
 */
public class AddSub extends LinearLayout {

    private View view;
    private TextView sub,num,add;

    public AddSub(Context context) {
        this(context,null);
    }

    public AddSub(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public AddSub(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initListener();
        getCount();
    }

    public void jia(){
        String s = num.getText().toString();
        int anInt = Integer.parseInt(s);
        anInt++;
        num.setText(anInt+"");
    }

    public void jian(){
        String s = num.getText().toString();
        int anInt = Integer.parseInt(s);
        if(anInt>1){
            anInt--;
            num.setText(anInt+"");
        }else{
            Toast.makeText(getContext(),"最后一条了",Toast.LENGTH_SHORT).show();
        }
    }

    private int getCount() {
        return Integer.parseInt(num.getText().toString());
    }

    private void initListener() {
        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jia();
            }
        });
        sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jian();
            }
        });
    }

    private void initView(Context context) {
        view = View.inflate(context, R.layout.add, this);
        sub = view.findViewById(R.id.sub);
        num = view.findViewById(R.id.num);
        add = view.findViewById(R.id.add);
        num.setText("1");
    }
}
