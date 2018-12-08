package com.bw.qgs.qgs2.circle.presenter;

import com.bw.qgs.qgs2.circle.model.MyCicleModel;
import com.bw.qgs.qgs2.circle.view.MyCicleView;

/**
 * date:2018/12/7    13:49
 * author:秦广帅(Lenovo)
 * fileName:MyCiclePresenter
 */
public class MyCiclePresenter {

    private MyCicleView mMyCicleView;
    private MyCicleModel mMyCicleModel;

    public MyCiclePresenter(MyCicleView myCicleView) {
        mMyCicleView = myCicleView;
        mMyCicleModel = new MyCicleModel();
    }

    public void cicle(String url) {
        mMyCicleModel.cicle(url, new MyCicleModel.HttpCicleCallBack() {
            @Override
            public void getCicle(String s) {
                if (s != null) {
                    mMyCicleView.onCicleCuccess(s);
                } else {
                    mMyCicleView.onCicleFailer("失败");
                }
            }
        });
    }
}
