package com.bw.qgs.qgs2.login.presenter;

import com.bw.qgs.qgs2.login.bean.LoginUser;
import com.bw.qgs.qgs2.login.model.LoginModel;
import com.bw.qgs.qgs2.login.view.RegisnView;
import com.bw.qgs.qgs2.url.BaseRequest;

/**
 * date:2018/12/1    14:39
 * author:秦广帅(Lenovo)
 * fileName:LoginPresenter
 */
public class LoginPresenter {

    private RegisnView mRegisnView;
    private LoginModel mLoginModel;

    public LoginPresenter(RegisnView regisnView) {
        mRegisnView = regisnView;
        mLoginModel = new LoginModel();
    }

    public void login(String url, String phone, String pwd, BaseRequest baseRequest) {
        mLoginModel.login(url, phone, pwd, baseRequest, new LoginModel.HttpCallBack() {
            @Override
            public void getData(String s, LoginUser loginUser) {
                if (s != null) {
                    mRegisnView.onSuccess(s,loginUser);
                } else {
                    mRegisnView.onFailer("登录失败");
                }
            }
        });
    }
}
