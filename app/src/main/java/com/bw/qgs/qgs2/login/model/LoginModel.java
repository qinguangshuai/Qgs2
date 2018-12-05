package com.bw.qgs.qgs2.login.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs2.login.bean.LoginUser;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.BaseRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/1    14:33
 * author:秦广帅(Lenovo)
 * fileName:LoginModel
 */
public class LoginModel {
    public void login(String url, String phone, String pwd, BaseRequest baseRequest, final HttpCallBack httpCallBack) {
        OkHttpUtil.executePost(url+phone+pwd, baseRequest, new Callback() {
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
                        LoginUser loginUser = gson.fromJson(string, LoginUser.class);
                        LoginUser.ResultBean result = loginUser.getResult();
                        httpCallBack.getData(string,loginUser);
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
        void getData(String s,LoginUser loginUser);
    }
}
