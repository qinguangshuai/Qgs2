package com.bw.qgs.qgs2.updataname.presenter;

import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;
import com.bw.qgs.qgs2.updataname.view.UpdateView;

/**
 * date:2018/12/13    14:33
 * author:秦广帅(Lenovo)
 * fileName:UpdatePresenter
 */
public class UpdatePresenter {

    private UpdateView mUpdateView;
    private HttpManager mHttpManager;

    public UpdatePresenter(UpdateView updateView) {
        mUpdateView = updateView;
        mHttpManager = new HttpManager();
    }

    public void putUpdate(String url, String nickName) {
        mHttpManager.putXiuMethod(url, nickName, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                if (result != null) {
                    mUpdateView.onUpdateSuccess(result);
                }
            }

            @Override
            public void onRetrofitFailer(String result) {
                mUpdateView.onUpdateFailer("失败");
            }
        });
    }
}
