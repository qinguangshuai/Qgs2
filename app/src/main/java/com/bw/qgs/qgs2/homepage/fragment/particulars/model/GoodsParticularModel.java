package com.bw.qgs.qgs2.homepage.fragment.particulars.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/8    14:34
 * author:秦广帅(Lenovo)
 * fileName:GoodsParticularModel
 */
public class GoodsParticularModel {
    public void par(String url, final HttpGoodsBack httpGoodsBack) {
        OkHttpUtil.executeGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                Gson gson = new Gson();
                Particulars particulars = gson.fromJson(s, Particulars.class);
                final Particulars.ResultBean result = particulars.getResult();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpGoodsBack.getGoodsData(result);
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

    public interface HttpGoodsBack {
        void getGoodsData(Particulars.ResultBean resultBean);
    }
}
