package com.bw.qgs.qgs2.myaddress;

import com.bw.qgs.qgs2.myaddress.view.AddressView;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.HttpManager;

/**
 * date:2018/12/15    8:46
 * author:秦广帅(Lenovo)
 * fileName:MoAddressPresenter
 */
public class MoAddressPresenter {

    private AddressView mAddressView;
    private HttpManager mHttpManager;

    public MoAddressPresenter(AddressView addressView) {
        mAddressView = addressView;
        mHttpManager = new HttpManager();
    }

    public void mo(String url,int id){
        mHttpManager.postMoMethod(url, id, new CallBack() {
            @Override
            public void onRetrofitSuccess(String result) {
                mAddressView.onMoSuccess(result);
            }

            @Override
            public void onRetrofitFailer(String result) {
                mAddressView.onFailer("失败");
            }
        });
    }
}
