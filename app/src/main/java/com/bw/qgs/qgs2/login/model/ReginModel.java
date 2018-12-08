package com.bw.qgs.qgs2.login.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.login.bean.ReginUser;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/1    15:24
 * author:秦广帅(Lenovo)
 * fileName:ReginModel
 */
public class ReginModel {
    public void regin(String url, String phone, String pwd, BaseRequest baseRequest, final HttpCallBack httpCallBack){
        OkHttpUtil.executePost(url + phone + pwd, baseRequest, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        ReginUser reginUser = gson.fromJson(string, ReginUser.class);

                        String s = reginUser.getMessage();

                        httpCallBack.getData(s);
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
