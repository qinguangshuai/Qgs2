package com.bw.qgs.qgs2.okhttp;

import com.bw.qgs.qgs2.url.LogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/5    15:44
 * author:秦广帅(Lenovo)
 * fileName:OkHttpCallBack
 */
public class OkHttpCallBack implements Callback {

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        int code = response.code();
        String string = response.body().string();
        switch (code){
            case 200:
                LogUtil.i("登陆成功");
                break;
            case 307:
                LogUtil.d("");
                break;
            case 400:
                LogUtil.e("请求失败");
                break;
            case 404:
                LogUtil.e("资源未找到");
                break;
                default:
                    break;
        }
    }
}
