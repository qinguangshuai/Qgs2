package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;
import com.bw.qgs.qgs2.model.HttpManager5;
import com.bw.qgs.qgs2.model.HttpManager6;
import com.bw.qgs.qgs2.retrofit.CallBack;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class ErPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private HttpManager6 mHttpManager;

    public ErPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mHttpManager = new HttpManager6();
    }

    public void erji(String url,String id) {
        mHttpManager.getYiFu6(url,id, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mOneFragmentOneView.onerSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mOneFragmentOneView.onFailer("失败");
            }
        });
    }
}
