package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.ShoeModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/4    11:28
 * author:秦广帅(Lenovo)
 * fileName:ShopPresenter
 */
public class ShoePresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private ShoeModel mShoeModel;

    public ShoePresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mShoeModel = new ShoeModel();
    }

    public void shoe(String url){
        mShoeModel.shope(url, new ShoeModel.HttpCallBack() {
            @Override
            public void getData(String s) {
                if(s!=null){
                    mOneFragmentOneView.onShopSuccess(s);
                }else{
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
