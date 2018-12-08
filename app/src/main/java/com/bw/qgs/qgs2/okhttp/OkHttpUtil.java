package com.bw.qgs.qgs2.okhttp;

import com.bw.qgs.qgs2.url.BaseRequest;
import com.bw.qgs.qgs2.url.OKHeaderInterceptor;
import com.bw.qgs.qgs2.url.OkLogInterceptor;
import com.google.gson.Gson;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * date:2018/12/1    11:58
 * author:秦广帅(Lenovo)
 * fileName:OkHttpUtil
 */
public class OkHttpUtil {

    public static Gson gson = new Gson();
    public static final String MEDIO_TYPE = "application/json; charset=utf-8";
    public static final String MEDIO_POST = "POST";
    public static final String MEDIO_GET = "GET";
    private static OkHttpClient client;

    //单例模式
    private OkHttpUtil() {

    }

    public static void init() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.retryOnConnectionFailure(true);
            builder.addInterceptor(new OKHeaderInterceptor());
            builder.addInterceptor(new OkLogInterceptor());
            client=builder.build();
    }

    private static Request creat(String url, String method, BaseRequest baseRequest) {
        RequestBody requestBody = null;
        if (baseRequest != null) {
            String json = gson.toJson(baseRequest);
            MediaType parse = MediaType.parse(MEDIO_TYPE);
            requestBody = RequestBody.create(parse, json);
        }
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case MEDIO_POST:
                request = builder.post(requestBody).build();
                break;
            case MEDIO_GET:
                request = builder.build();
                break;
        }
        return request;
    }

    public static void executePost(String url, BaseRequest baseRequest, Callback callback) {
        Request request = creat(url, MEDIO_POST, baseRequest);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static void executeGet(String url,Callback callback){
        Request request = creat(url, MEDIO_GET,null);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
