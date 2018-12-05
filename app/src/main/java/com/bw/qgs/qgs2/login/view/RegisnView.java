package com.bw.qgs.qgs2.login.view;

import com.bw.qgs.qgs2.login.bean.LoginUser;

/**
 * date:2018/12/1    11:48
 * author:秦广帅(Lenovo)
 * fileName:RegisnView
 */
public interface RegisnView {
    void onSuccess(String result, LoginUser loginUser);
    void onResignSuccess(String result);
    void onFailer(String msg);
    void onResignFailer(String msg);
}
