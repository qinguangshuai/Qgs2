package com.bw.qgs.qgs2.model;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

/**
 * date:2018/12/15    17:17
 * author:秦广帅(Lenovo)
 * fileName:HttpManager3
 */
public class HttpManager3 {
    public void getQueryDing(String url, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.getQueryDing(url);
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
