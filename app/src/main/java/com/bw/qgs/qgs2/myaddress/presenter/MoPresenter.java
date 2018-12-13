package com.bw.qgs.qgs2.myaddress.presenter;

import com.bw.qgs.qgs2.myaddress.model.MoModel;
import com.bw.qgs.qgs2.myaddress.view.AddressView;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.xinzeng.model.XingZengModel;
import com.bw.qgs.qgs2.xinzeng.view.XinZengView;

/**
 * date:2018/12/11    10:35
 * author:秦广帅(Lenovo)
 * fileName:XinZengPresenter
 */
public class MoPresenter {

    private AddressView mAddressView;
    private MoModel mMoModel;

    public MoPresenter(AddressView xinZengView) {
        mAddressView = xinZengView;
        mMoModel = new MoModel();
    }

    public void mo(String url,BaseRequest baseRequest){
        mMoModel.mo(url, baseRequest, new MoModel.HttpMoCallBack() {
            @Override
            public void getMoData(String s) {
                if (s!=null){
                    mAddressView.onMoSuccess(s);
                }else{
                    mAddressView.onFailer("失败");
                }
            }
        });
    }
}
