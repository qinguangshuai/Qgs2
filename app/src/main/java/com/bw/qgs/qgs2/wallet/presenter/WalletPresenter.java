package com.bw.qgs.qgs2.wallet.presenter;

import com.bw.qgs.qgs2.wallet.model.WalletModel;
import com.bw.qgs.qgs2.wallet.view.WalletView;

/**
 * date:2018/12/5    8:13
 * author:秦广帅(Lenovo)
 * fileName:WalletPresenter
 */
public class WalletPresenter {

    private WalletView mWalletView;
    private WalletModel mWalletModel;

    public WalletPresenter(WalletView walletView) {
        mWalletView = walletView;
        mWalletModel = new WalletModel();
    }

    public void wallet(String url){
        mWalletModel.wallet(url, new WalletModel.HttpCall() {
            @Override
            public void getBase(String s) {
                if(s!=null){
                    mWalletView.onWalletSuccess(s);
                }else{
                    mWalletView.onWalletFailer("失败");
                }
            }
        });
    }
}
