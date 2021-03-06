package com.bw.qgs.qgs2.retrofit;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
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
    @FormUrlEncoded
    Call<String> postMethod(@Url String url);

    @POST
    @FormUrlEncoded
    Call<String> postZanMethod(@Url String url, @Field("circleId") int circleId);

    @POST
    @FormUrlEncoded
    Call<String> postHeadMethod(@Url String url, @Field("image") File image);

    @DELETE
    Call<String> postCancleZanMethod(@Url String url, @Query("circleId") int circleId);

    @DELETE
    Call<String> deleteCicleZanMethod(@Url String url, @Query("circleId") int circleId);

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

    @POST
    @FormUrlEncoded
    Call<String> postMoMethod(@Url String url, @Field("id") int id);

    @POST
    @FormUrlEncoded
    Call<String> postDingMethod(@Url String url, @Field("orderInfo") String orderInfo,@Field("totalPrice") double totalPrice,@Field("addressId") int addressId);

    @GET
    Call<String> getQueryDing(@Url String url);

    @GET
    Call<String> getQueryFu(@Url String url);

    @GET
    Call<String> getYiFu(@Url String url);

    @GET
    Call<String> getYiFu6(@Url String url,@Query("firstCategoryId") String id);

    @GET
    Call<String> getYiFu7(@Url String url,@Query("categoryId") String id,@Query("page") int page,@Query("count") int count);
}
