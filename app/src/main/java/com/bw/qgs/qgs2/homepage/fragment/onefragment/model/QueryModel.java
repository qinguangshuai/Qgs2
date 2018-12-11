package com.bw.qgs.qgs2.homepage.fragment.onefragment.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/9    12:04
 * author:秦广帅(Lenovo)
 * fileName:QueryModel
 */
public class QueryModel {

    public void query1(String url, final HttpQueryCallBa httpQueryCallBa){
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
                        httpQueryCallBa.getQueryGoods(s);
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

    public interface HttpQueryCallBa {
        void getQueryGoods(String s);
    }
}
