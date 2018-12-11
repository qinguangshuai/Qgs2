package com.bw.qgs.qgs2.myaddress.presenter;

import com.bw.qgs.qgs2.myaddress.model.AddressModel;
import com.bw.qgs.qgs2.myaddress.view.AddressView;

/**
 * date:2018/12/10    16:40
 * author:秦广帅(Lenovo)
 * fileName:AddressPresenter
 */
public class AddressPresenter {

    private AddressView mAddressView;
    private AddressModel mAddressModel;

    public AddressPresenter(AddressView addressView) {
        mAddressView = addressView;
        mAddressModel = new AddressModel();
    }

    public void addre(String url){
        mAddressModel.addre(url, new AddressModel.HttpAddressCall() {
            @Override
            public void getAddressBase(String s) {
                if(s!=null){
                    mAddressView.onSuccess(s);
                }else{
                    mAddressView.onFailer("失败");
                }
            }
        });
    }
}
