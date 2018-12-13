package com.bw.qgs.qgs2.retrofit;

import android.util.Log;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * date:2018/12/12    18:52
 * author:秦广帅(Lenovo)
 * fileName:HttpManager
 */
public class HttpManager {
    public void getMethod(String url, final CallBack callBack) {
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.getMethod(url);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                callBack.onRetrofitSuccess(s);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show();
                callBack.onRetrofitFailer("失败");
                Log.e("=====","失败");
            }
        });
    }

    public void postZanMethod(String url, int circleId, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.postZanMethod(url,circleId);
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

    public void putXiuMethod(String url, String nickName, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.putXiuMethod(url,nickName);
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

    public void putXiuPwdMethod(String url, String oldPwd,String newPwd, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.putXiuPwdMethod(url,oldPwd,newPwd);
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

    public void putXiuAddMethod(String url,int id,String realName,String phone,String address,String zipCode, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.putXiuAddMethod(url,id,realName,phone,address,zipCode);
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

    public void putShopMethod(String url,String data, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.putShopMethod(url,data);
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
