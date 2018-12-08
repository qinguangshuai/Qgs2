package com.bw.qgs.qgs2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bw.qgs.qgs2.okhttp.Constant;
import com.bw.qgs.qgs2.okhttp.OkHttpUtil;
import com.bw.qgs.qgs2.url.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.HashMap;

/**
 * date:2018/12/1    12:02
 * author:秦广帅(Lenovo)
 * fileName:App
 */
public class App extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        LogUtil.init();
        initHttpHeader();
        Fresco.initialize(this);
        ImageLoaderConfiguration builder = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(3)
                .build();
        ImageLoader.getInstance().init(builder);
        //清除缓存
        ImageLoader.getInstance().clearDiscCache();
        ImageLoader.getInstance().clearMemoryCache();
        ImagePipeline pipeline = Fresco.getImagePipeline();
        pipeline.clearCaches();
        pipeline.clearDiskCaches();
        pipeline.clearMemoryCaches();
    }

    private void initHttpHeader() {
        OkHttpUtil.init();
    }
}
