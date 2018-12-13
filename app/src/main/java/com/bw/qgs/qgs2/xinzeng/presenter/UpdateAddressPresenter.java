package com.bw.qgs.qgs2.xinzeng.presenter;

import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;
import com.bw.qgs.qgs2.xinzeng.view.UpdateAddressView;

/**
 * date:2018/12/13    15:23
 * author:秦广帅(Lenovo)
 * fileName:UpdateAddressPresenter
 */
public class UpdateAddressPresenter {

    private UpdateAddressView mUpdateAddressView;
    private HttpManager mHttpManager;

    public UpdateAddressPresenter(UpdateAddressView updateAddressView) {
        mUpdateAddressView = updateAddressView;
        mHttpManager = new HttpManager();
    }

    public void addresspre(String url,int id,String realName,String phone,String address,String zipCode){
        mHttpManager.putXiuAddMethod(url, id, realName, phone, address, zipCode, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                if (result!=null){
                    mUpdateAddressView.onUpAddSuccess(result);
                }
            }

            @Override
            public void onRetrofitFailer(String result) {
                mUpdateAddressView.onUpAddFailer("失败");
            }
        });
    }
}
