package com.bw.qgs.qgs2.homepage.fragment.particulars.view;

import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;

/**
 * date:2018/12/8    14:26
 * author:秦广帅(Lenovo)
 * fileName:GoodsParticularView
 */
public interface GoodsParticularView {
    void onGoodsParticuSuccess(Particulars.ResultBean resultBean);
    void onGoodsParticuFailer(String msg);
}
