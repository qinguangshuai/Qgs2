package com.bw.qgs.qgs2.xinzeng.presenter;

import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.xinzeng.model.XingZengModel;
import com.bw.qgs.qgs2.xinzeng.view.XinZengView;

/**
 * date:2018/12/11    10:35
 * author:秦广帅(Lenovo)
 * fileName:XinZengPresenter
 */
public class XinZengPresenter {

    private XinZengView mXinZengView;
    private XingZengModel mXingZengModel;

    public XinZengPresenter(XinZengView xinZengView) {
        mXinZengView = xinZengView;
        mXingZengModel = new XingZengModel();
    }

    public void xin(String url, String realName, String phone, String address, String zipCode, BaseRequest baseRequest){
        mXingZengModel.xin(url, realName, phone, address, zipCode, baseRequest, new XingZengModel.HttpCallBack() {
            @Override
            public void getData(String s) {
                if (s!=null){
                    mXinZengView.onSuccess(s);
                }else{
                    mXinZengView.onFailer("失败");
                }
            }
        });
    }
}
