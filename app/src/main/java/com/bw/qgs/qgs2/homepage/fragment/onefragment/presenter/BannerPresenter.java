package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.BannerModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/5    11:00
 * author:秦广帅(Lenovo)
 * fileName:BannerPresenter
 */
public class BannerPresenter {
    private OneFragmentOneView mOneFragmentOneView;
    private BannerModel mBannerModel;

    public BannerPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mBannerModel = new BannerModel();
    }

    public void banner(String url){
        mBannerModel.banner(url, new BannerModel.HttpCallBac() {
            @Override
            public void getData(String s) {
                if(s!=null){
                    mOneFragmentOneView.onBannerSuccess(s);
                }else{
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
