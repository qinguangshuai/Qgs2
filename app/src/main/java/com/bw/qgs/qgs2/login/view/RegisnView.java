package com.bw.qgs.qgs2.login.view;

/**
 * date:2018/12/1    11:48
 * author:秦广帅(Lenovo)
 * fileName:RegisnView
 */
public interface RegisnView {
    void onSuccess(String result);
    void onResignSuccess(String result);
    void onFailer(String msg);
    void onResignFailer(String msg);
}
