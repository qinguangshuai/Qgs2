package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.OneFragmentOneModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

import java.util.List;

/**
 * date:2018/12/3    13:57
 * author:秦广帅(Lenovo)
 * fileName:OneFragmentOnePresenter
 */
public class OneFragmentOnePresenter {
    private OneFragmentOneView mOneFragmentOneView;
    private OneFragmentOneModel mOneFragmentOneModel;

    public OneFragmentOnePresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mOneFragmentOneModel = new OneFragmentOneModel();
    }

    public void one(String url) {
        mOneFragmentOneModel.one(url, new OneFragmentOneModel.HttpCallBack() {
            @Override
            public void getData(TwoAdapterBean.ResultBean resultBeans) {
                if(resultBeans!=null){
                    mOneFragmentOneView.onSuccess(resultBeans);
                }else{
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
