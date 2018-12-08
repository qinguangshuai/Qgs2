package com.bw.qgs.qgs2.homepage.fragment.twofragment.ady;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;

/**
 * date:2018/12/7    18:36
 * author:秦广帅(Lenovo)
 * fileName:Add
 */
public class Add extends LinearLayout {

    private View mView;
    private ImageView text1;
    private TextView text2;

    public Add(Context context) {
        this(context, null);
    }

    public Add(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public Add(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initListener();
        getCount();
    }

    private void initListener() {
        text1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jia();
            }
        });
    }

    private void initView(Context context) {
        mView = View.inflate(context, R.layout.zang, this);
        text1 = mView.findViewById(R.id.zangText1);
        text2 = mView.findViewById(R.id.zangText2);
        text1.setImageResource(R.drawable.common_btn_prise_n_xhdpi);
        text2.setText("0");
    }

    public void jia() {
        text1.setImageResource(R.drawable.common_btn_prise_s_xhdpi);
        String s = text2.getText().toString();
        int anInt = Integer.parseInt(s);
        anInt++;
        text2.setText(anInt + "");
    }

    public void jian() {
        text1.setImageResource(R.drawable.common_btn_prise_n_xhdpi);
        String s = text2.getText().toString();
        int anInt = Integer.parseInt(s);
        anInt--;
        text2.setText(anInt + "");
    }

    public int getCount() {
        return Integer.parseInt(text2.getText().toString());
    }
}
