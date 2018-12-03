package com.bw.qgs.qgs2.homepage.fragment.onefragment.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/3    13:35
 * author:秦广帅(Lenovo)
 * fileName:OneFragmentOneModel
 */
public class OneFragmentOneModel {
    public void one(String url, final HttpCallBack httpCallBack) {
        OkHttpUtil.executeGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                Gson gson = new Gson();
                TwoAdapterBean twoAdapterBean = gson.fromJson(s, TwoAdapterBean.class);
                final TwoAdapterBean.ResultBean result = twoAdapterBean.getResult();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.getData(result);
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

    public interface HttpCallBack{
        void getData(TwoAdapterBean.ResultBean resultBeans);
    }
}
