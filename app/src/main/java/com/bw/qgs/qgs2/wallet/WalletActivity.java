package com.bw.qgs.qgs2.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;
import com.bw.qgs.qgs2.wallet.presenter.WalletPresenter;
import com.bw.qgs.qgs2.wallet.view.WalletView;
import com.google.gson.Gson;

import java.util.List;

public class WalletActivity extends AppCompatActivity implements WalletView {

    private WalletPresenter mWalletPresenter;
    private List<WalletUser.ResultBean.DetailListBean> mDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        mWalletPresenter = new WalletPresenter(this);
        mWalletPresenter.wallet(UrlUtil.WALLET);
    }

    @Override
    public void onWalletSuccess(String result) {
        Gson gson = new Gson();
        WalletUser walletUser = gson.fromJson(result, WalletUser.class);
        mDetailList = walletUser.getResult().getDetailList();
    }

    @Override
    public void onWalletFailer(String msg) {

    }
}
