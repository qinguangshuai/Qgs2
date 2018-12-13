package com.bw.qgs.qgs2.homepage.fragment.threefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.threefragment.view.ThreeFragmentView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

/**
 * date:2018/12/13    19:10
 * author:秦广帅(Lenovo)
 * fileName:ThreeFragmentPresenter
 */
public class ThreeFragmentPresenter {

    private ThreeFragmentView mThreeFragmentView;
    private HttpManager mHttpManager;

    public ThreeFragmentPresenter(ThreeFragmentView threeFragmentView) {
        mThreeFragmentView = threeFragmentView;
        mHttpManager = new HttpManager();
    }

    public void threeshop(String url){
        mHttpManager.getMethod(url, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mThreeFragmentView.onThreeSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mThreeFragmentView.onThreeFailer("失败");
            }
        });
    }
}
