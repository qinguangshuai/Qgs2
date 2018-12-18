package com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.fu;

import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding.QuanDingView;
import com.bw.qgs.qgs2.model.HttpManager3;
import com.bw.qgs.qgs2.model.HttpManager4;
import com.bw.qgs.qgs2.retrofit.CallBack;

/**
 * date:2018/12/15    17:38
 * author:秦广帅(Lenovo)
 * fileName:QuanDingPresenter
 */
public class QuanFuPresenter {

    private QuanFuView mQuanFuView;
    private HttpManager4 mHttpManager4;

    public QuanFuPresenter(QuanFuView quanFuView) {
        mQuanFuView = quanFuView;
        mHttpManager4 = new HttpManager4();
    }

    public void getQueryFu(String url){
        mHttpManager4.getQueryFu(url, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mQuanFuView.onQuanFuSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mQuanFuView.onQuanFuFailer("失败");
            }
        });
    }
}
