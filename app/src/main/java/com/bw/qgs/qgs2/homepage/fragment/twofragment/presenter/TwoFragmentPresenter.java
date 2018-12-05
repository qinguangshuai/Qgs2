package com.bw.qgs.qgs2.homepage.fragment.twofragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.twofragment.model.TwoFragmentModel;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.view.TwoFragmentView;

/**
 * date:2018/12/3    20:52
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentPresenter
 */
public class TwoFragmentPresenter {
    private TwoFragmentView mTwoFragmentView;
    private TwoFragmentModel mTwoFragmentModel;

    public TwoFragmentPresenter(TwoFragmentView twoFragmentView) {
        mTwoFragmentView = twoFragmentView;
        mTwoFragmentModel = new TwoFragmentModel();
    }

    public void cicle(String url){
        mTwoFragmentModel.cicle(url, new TwoFragmentModel.HttpCallBack() {
            @Override
            public void getData(String s) {
                if(s!=null){
                    mTwoFragmentView.onSuccess(s);
                }else{
                    mTwoFragmentView.onFailer("失败");
                }
            }
        });
    }
}
