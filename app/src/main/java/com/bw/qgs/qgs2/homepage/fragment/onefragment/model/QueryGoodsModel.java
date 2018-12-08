package com.bw.qgs.qgs2.homepage.fragment.onefragment.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/5    19:39
 * author:秦广帅(Lenovo)
 * fileName:QueryGoodsModel
 */
public class QueryGoodsModel {
    public void goods(String url, final HttpCallBa httpCallBa){
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
                        httpCallBa.getGoods(s);
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

    public interface HttpCallBa {
        void getGoods(String s);
    }
}
