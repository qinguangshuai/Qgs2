package com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding;

import com.bw.qgs.qgs2.model.HttpManager3;
import com.bw.qgs.qgs2.retrofit.CallBack;

/**
 * date:2018/12/15    17:38
 * author:秦广帅(Lenovo)
 * fileName:QuanDingPresenter
 */
public class QuanDingPresenter {

    private QuanDingView mQuanDingView;
    private HttpManager3 mHttpManager3;

    public QuanDingPresenter(QuanDingView quanDingView) {
        mQuanDingView = quanDingView;
        mHttpManager3 = new HttpManager3();
    }

    public void getQuery(String url){
        mHttpManager3.getQueryDing(url, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mQuanDingView.onQuanSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mQuanDingView.onQuanFailer("失败");
            }
        });
    }
}
