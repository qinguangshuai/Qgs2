package com.bw.qgs.qgs2.xinzeng.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.login.bean.LoginUser;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.xinzeng.bean.XinZeng;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/11    10:18
 * author:秦广帅(Lenovo)
 * fileName:XingZengModel
 */
public class XingZengModel {

    public void xin(String url, String realName, String phone, String address, String zipCode, BaseRequest baseRequest, final HttpCallBack httpCallBack){
        OkHttpUtil.executePost(url + realName + phone + address + zipCode, baseRequest, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                Gson gson = new Gson();
                XinZeng xinZeng = gson.fromJson(s, XinZeng.class);
                final String status = xinZeng.getStatus();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.getData(status);
                    }
                });
            }
        });
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public interface HttpCallBack {
        void getData(String s);
    }
}
