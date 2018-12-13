package com.bw.qgs.qgs2.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;

/**
 * date:2018/12/12    20:02
 * author:秦广帅(Lenovo)
 * fileName:RetrofitApi
 */
public interface RetrofitApi {

    @GET
    Call<String> getMethod(@Url String url);

    @POST
    Call<String> postMethod(@Url String url);

    @POST
    @FormUrlEncoded
    Call<String> postZanMethod(@Url String url, @Field("circleId") int circleId);

    @PUT
    @FormUrlEncoded
    Call<String> putXiuMethod(@Url String url, @Field("nickName") String nickName);

    @PUT
    @FormUrlEncoded
    Call<String> putXiuAddMethod(@Url String url, @Field("id") int id, @Field("realName") String realName, @Field("phone") String phone, @Field("address") String address, @Field("zipCode") String zipCode);

    @PUT
    @FormUrlEncoded
    Call<String> putXiuPwdMethod(@Url String url, @Field("oldPwd") String oldPwd,@Field("newPwd") String newPwd);

    @PUT
    @FormUrlEncoded
    Call<String> putShopMethod(@Url String url,@Field("data") String data);
}
