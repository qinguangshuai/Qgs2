package com.bw.qgs.qgs2.homepage.fragment.threefragment;

import com.bw.qgs.qgs2.homepage.fragment.threefragment.view.ThreeFragmentView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.model.HttpManager1;

/**
 * date:2018/12/15    10:48
 * author:秦广帅(Lenovo)
 * fileName:DingPresenter
 */
public class DingPresenter {

    private ThreeFragmentView mThreeFragmentView;
    private HttpManager1 mHttpManager;

    public DingPresenter(ThreeFragmentView threeFragmentView) {
        mThreeFragmentView = threeFragmentView;
        mHttpManager = new HttpManager1();
    }

    public void getDing(String url, String orderInfo, double totalPrice, int addressId){
        mHttpManager.postDingMethod(url, orderInfo, totalPrice, addressId, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mThreeFragmentView.onDingSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mThreeFragmentView.onThreeFailer("失败");
            }
        });
    }
}
