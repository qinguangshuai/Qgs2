package com.bw.qgs.qgs2.myaddress.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.myaddress.bean.MoRenUser;
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
public class MoModel {

    public void mo(String url, BaseRequest baseRequest, final HttpMoCallBack httpMoCallBack){
        OkHttpUtil.executePost(url , baseRequest, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                Gson gson = new Gson();
                MoRenUser moRenUser = gson.fromJson(s, MoRenUser.class);
                final String status = moRenUser.getStatus();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpMoCallBack.getMoData(status);
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

    public interface HttpMoCallBack {
        void getMoData(String s);
    }
}
