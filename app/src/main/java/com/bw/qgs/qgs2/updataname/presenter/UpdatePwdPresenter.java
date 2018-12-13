package com.bw.qgs.qgs2.updataname.presenter;

import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;
import com.bw.qgs.qgs2.updataname.view.UpdatePwdView;

/**
 * date:2018/12/13    16:42
 * author:秦广帅(Lenovo)
 * fileName:UpdatePwdPresenter
 */
public class UpdatePwdPresenter {

    private UpdatePwdView mUpdatePwdView;
    private HttpManager mHttpManager;

    public UpdatePwdPresenter(UpdatePwdView updatePwdView) {
        mUpdatePwdView = updatePwdView;
        mHttpManager = new HttpManager();
    }

    public void putXiuPwdMethod(String url, String oldPwd,String newPwd){
        mHttpManager.putXiuPwdMethod(url, oldPwd, newPwd, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mUpdatePwdView.onUpdatePwdSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mUpdatePwdView.onUpdatePwdFailer("失败");
            }
        });
    }
}
