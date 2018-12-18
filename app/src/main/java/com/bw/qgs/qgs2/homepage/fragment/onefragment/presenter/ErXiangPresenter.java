package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;
import com.bw.qgs.qgs2.model.HttpManager5;
import com.bw.qgs.qgs2.model.HttpManager7;
import com.bw.qgs.qgs2.retrofit.CallBack;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class ErXiangPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private HttpManager7 mHttpManager;

    public ErXiangPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mHttpManager = new HttpManager7();
    }

    public void erjixiang(String url,String id,int page,int count) {
        mHttpManager.getYiFu7(url,id,page,count, new CallBack() {
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
