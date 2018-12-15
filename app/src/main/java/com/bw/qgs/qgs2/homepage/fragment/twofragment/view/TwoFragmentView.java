package com.bw.qgs.qgs2.homepage.fragment.twofragment.view;

/**
 * date:2018/12/3    20:48
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentView
 */
public interface TwoFragmentView {
    void onSuccess(String result);
    void onZanSuccess(String result);
    void onCancleZanSuccess(String result);
    void onFailer(String msg);
}
