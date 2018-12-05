package com.bw.qgs.qgs2;

import android.app.Application;
import android.content.SharedPreferences;

import com.bw.qgs.qgs2.okhttp.Constant;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashMap;

/**
 * date:2018/12/1    12:02
 * author:秦广帅(Lenovo)
 * fileName:App
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init();
        initHttpHeader();
        Fresco.initialize(this);
    }

    private void initHttpHeader() {
        HashMap<String,String> headers = new HashMap<>();
        SharedPreferences sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        headers.put("token",sharedPreferences.getString(Constant.TOKEN,""));
        headers.put("version", "version1.0");
        headers.put("platform", "android");
        OkHttpUtil.init(headers);
    }

}
