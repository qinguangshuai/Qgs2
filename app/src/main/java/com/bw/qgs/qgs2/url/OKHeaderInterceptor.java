package com.bw.qgs.qgs2.url;

import android.content.Context;

import com.bw.qgs.qgs2.App;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2018/12/2    10:49
 * author:秦广帅(Lenovo)
 * fileName:OKHeaderInterceptor
 */
public class OKHeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("platform","android");
        builder.addHeader("version","version1.0");
        builder.addHeader("sessionId",App.mContext.getSharedPreferences("login",Context.MODE_PRIVATE).getString("sessionId",""));
        builder.addHeader("userId",App.mContext.getSharedPreferences("login",Context.MODE_PRIVATE).getString("userId",""));
        request = builder.build();
        return chain.proceed(request);
    }
}
