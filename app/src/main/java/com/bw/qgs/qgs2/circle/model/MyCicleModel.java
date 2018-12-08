package com.bw.qgs.qgs2.circle.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/7    13:43
 * author:秦广帅(Lenovo)
 * fileName:MyCicleModel
 */
public class MyCicleModel {
    public void cicle(String url, final HttpCicleCallBack httpCicleCallBack) {
        OkHttpUtil.executeGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("===","111");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCicleCallBack.getCicle(s);
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

    public interface HttpCicleCallBack {
        void getCicle(String s);
    }
}
