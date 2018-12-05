package com.bw.qgs.qgs2.homepage.fragment.twofragment.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/3    20:49
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentModel
 */
public class TwoFragmentModel {
    public void cicle(String url, final HttpCallBack httpCallBack){
        OkHttpUtil.executeGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.getData(s);
                    }
                });
            }
        });
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public interface HttpCallBack{
        void getData(String s);
    }
}
