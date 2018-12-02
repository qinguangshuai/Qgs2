package com.bw.qgs.qgs2.login.presenter;

import com.bw.qgs.qgs2.login.model.ReginModel;
import com.bw.qgs.qgs2.login.view.RegisnView;
import com.bw.qgs.qgs2.url.BaseRequest;

/**
 * date:2018/12/1    15:29
 * author:秦广帅(Lenovo)
 * fileName:ReginPresenter
 */
public class ReginPresenter {
    private RegisnView mRegisnView;
    private ReginModel mReginModel;

    public ReginPresenter(RegisnView regisnView) {
        mRegisnView = regisnView;
        mReginModel = new ReginModel();
    }

    public void regin(String url, String phone, String pwd, BaseRequest baseRequest) {
        mReginModel.regin(url, phone, pwd, baseRequest, new ReginModel.HttpCallBack() {
            @Override
            public void getData(String s) {
                if (s != null) {
                    mRegisnView.onResignSuccess(s);
                } else {
                    mRegisnView.onResignFailer("注册失败");
                }
            }
        });
    }
}
