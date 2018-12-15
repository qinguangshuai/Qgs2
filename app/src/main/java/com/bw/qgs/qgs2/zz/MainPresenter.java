package com.bw.qgs.qgs2.zz;

import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

import java.io.File;

/**
 * date:2018/12/14    18:13
 * author:秦广帅(Lenovo)
 * fileName:MainPresenter
 */
public class MainPresenter {

    private MainView mMainView;
    private HttpManager mHttpManager;

    public MainPresenter(MainView mainView) {
        mMainView = mainView;
        mHttpManager = new HttpManager();
    }

    public void gettou(String url, File image){
        mHttpManager.postHeadMethod(url, image, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mMainView.onTouSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mMainView.onTouFailer("失败");
            }
        });
    }
}
