package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.OneDianModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.YiModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;
import com.bw.qgs.qgs2.model.HttpManager;
import com.bw.qgs.qgs2.model.HttpManager5;
import com.bw.qgs.qgs2.retrofit.CallBack;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class YiPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private HttpManager5 mHttpManager;

    public YiPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mHttpManager = new HttpManager5();
    }

    public void yiji(String url) {
        mHttpManager.getYiFu(url, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mOneFragmentOneView.onyiSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mOneFragmentOneView.onFailer("失败");
            }
        });
    }
}
