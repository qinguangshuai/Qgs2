package com.bw.qgs.qgs2.model;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * date:2018/12/16    11:24
 * author:秦广帅(Lenovo)
 * fileName:HttpManager4
 */
public class HttpManager4 {
    public void getQueryFu(String url, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.getQueryFu(url);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                callBack.onRetrofitSuccess(s);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callBack.onRetrofitFailer("失败");
            }
        });
    }
}
