package com.bw.qgs.qgs2.homepage.fragment.twofragment;

import com.bw.qgs.qgs2.homepage.fragment.twofragment.view.TwoFragmentView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

/**
 * date:2018/12/13    11:18
 * author:秦广帅(Lenovo)
 * fileName:ZanPresenter
 */
public class CancleZanPresenter {

    private TwoFragmentView mTwoFragmentView;
    private HttpManager mHttpManager;

    public CancleZanPresenter(TwoFragmentView twoFragmentView) {
        mTwoFragmentView = twoFragmentView;
        mHttpManager = new HttpManager();
    }

    public void deletezan(String url, int circleid) {
        mHttpManager.postCancleZanMethod(url, circleid, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                if (result != null) {
                    mTwoFragmentView.onCancleZanSuccess(result);
                }
            }

            @Override
            public void onRetrofitFailer(String result) {

            }
        });
    }
}
