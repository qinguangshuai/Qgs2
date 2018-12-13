package com.bw.qgs.qgs2.homepage.fragment.particulars.shop;

import com.bw.qgs.qgs2.homepage.fragment.particulars.view.GoodsParticularView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

/**
 * date:2018/12/13    17:55
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class ShopPresenter {

    private GoodsParticularView mGoodsParticularView;
    private HttpManager mHttpManager;

    public ShopPresenter(GoodsParticularView goodsParticularView) {
        mGoodsParticularView = goodsParticularView;
        mHttpManager = new HttpManager();
    }

    public void shop(String url, String data){
        mHttpManager.putShopMethod(url, data, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mGoodsParticularView.onShopSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mGoodsParticularView.onGoodsParticuFailer("失败");
            }
        });
    }
}
