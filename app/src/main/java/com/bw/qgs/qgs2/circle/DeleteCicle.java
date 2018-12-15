package com.bw.qgs.qgs2.circle;

import com.bw.qgs.qgs2.circle.view.MyCicleView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

/**
 * date:2018/12/14    13:53
 * author:秦广帅(Lenovo)
 * fileName:DeleteCicle
 */
public class DeleteCicle {

    private MyCicleView mMyCicleView;
    private HttpManager mHttpManager;

    public DeleteCicle(MyCicleView myCicleView) {
        mMyCicleView = myCicleView;
        mHttpManager = new HttpManager();
    }

    public void getDelete(String url,int circleId){
        mHttpManager.deleteCicleMethod(url, circleId, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mMyCicleView.onDeleteCicleCuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mMyCicleView.onCicleFailer("失败");
            }
        });
    }
}
