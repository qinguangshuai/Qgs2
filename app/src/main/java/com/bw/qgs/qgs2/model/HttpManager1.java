package com.bw.qgs.qgs2.model;

import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.retrofit.CallBack;
import com.bw.qgs.qgs2.retrofit.RetrofitApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * date:2018/12/15    17:10
 * author:秦广帅(Lenovo)
 * fileName:HttpManager1
 */
//订单
public class HttpManager1 {
    public void postDingMethod(String url,String orderInfo,double totalPrice,int addressId, final CallBack callBack){
        RetrofitApi retrofitApi = OkHttpUtil.retrofit.create(RetrofitApi.class);
        Call<String> call = retrofitApi.postDingMethod(url,orderInfo,totalPrice,addressId);
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
