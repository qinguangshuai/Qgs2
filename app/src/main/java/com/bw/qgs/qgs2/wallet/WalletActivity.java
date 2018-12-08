package com.bw.qgs.qgs2.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.footer.FooterActivity;
import com.bw.qgs.qgs2.footer.adapter.FooterAdapter;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.wallet.adapter.WalletAdapter;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;
import com.bw.qgs.qgs2.wallet.presenter.WalletPresenter;
import com.bw.qgs.qgs2.wallet.view.WalletView;
import com.google.gson.Gson;

import java.util.List;

public class WalletActivity extends AppCompatActivity implements WalletView {

    private WalletPresenter mWalletPresenter;
    private List<WalletUser.ResultBean.DetailListBean> mDetailList;
    private RecyclerView walletrecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        walletrecycle = findViewById(R.id.walletRecycle);
        mWalletPresenter = new WalletPresenter(this);
        mWalletPresenter.wallet(UrlUtil.WALLET);
    }

    @Override
    public void onWalletSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        walletrecycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        WalletUser walletUser = gson.fromJson(result, WalletUser.class);
        mDetailList = walletUser.getResult().getDetailList();
        if (mDetailList!=null){
            WalletAdapter walletAdapter = new WalletAdapter(getApplicationContext(),mDetailList);
            walletrecycle.setAdapter(walletAdapter);
        }
        else {
            Toast.makeText(WalletActivity.this,""+mDetailList.size(),Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(),""+mDetailList,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWalletFailer(String msg) {

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
