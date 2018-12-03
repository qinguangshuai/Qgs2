package com.bw.qgs.qgs2.homepage.fragment.onefragment.view;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;

import java.util.List;

/**
 * date:2018/12/3    13:45
 * author:秦广帅(Lenovo)
 * fileName:OneFragmentOneView
 */
public interface OneFragmentOneView {
    void onSuccess(TwoAdapterBean.ResultBean resultBeans);
    void onFailer(String msg);
}
