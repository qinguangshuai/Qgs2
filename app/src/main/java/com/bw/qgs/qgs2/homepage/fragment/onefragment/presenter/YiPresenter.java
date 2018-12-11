package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.OneDianModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.YiModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class YiPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private YiModel mYiModel;

    public YiPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mYiModel = new YiModel();
    }

    public void yi(String url) {
        mYiModel.yi(url, new YiModel.HttpYiCallBack() {
            @Override
            public void getYiData(String s) {
                if (s != null) {
                    mOneFragmentOneView.onOneDianSuccess(s);
                } else {
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
