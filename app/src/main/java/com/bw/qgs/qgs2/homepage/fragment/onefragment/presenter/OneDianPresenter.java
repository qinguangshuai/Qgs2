package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.OneDianModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class OneDianPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private OneDianModel mDianModel;

    public OneDianPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mDianModel = new OneDianModel();
    }

    public void dian(String url) {
        mDianModel.dian(url, new OneDianModel.HttpDianCallBack() {
            @Override
            public void getData(String s) {
                if (s != null) {
                    mOneFragmentOneView.onOneDianSuccess(s);
                } else {
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
