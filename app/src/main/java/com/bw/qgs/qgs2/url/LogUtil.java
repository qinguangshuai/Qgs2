package com.bw.qgs.qgs2.url;

import android.text.TextUtils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * date:2018/11/29    9:57
 * author:秦广帅(Lenovo)
 * fileName:LogUtil
 */
public class LogUtil {
    public static  void init(){
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .methodOffset(7)
                .logStrategy(null)
                .tag("bway")
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
    public static void json(String json){
        if(!TextUtils.isEmpty(json)){
            Logger.json(json);
        }
    }
    public static void json(String tag,String json){
        if(!TextUtils.isEmpty(json)){
            Logger.t(tag).json(json);
        }
    }
    public static void d(String msg){
        if(!TextUtils.isEmpty(msg)){
            Logger.d(msg);
        }
    }
    public static void d(String tag,String msg){
        if(!TextUtils.isEmpty(msg)){
            Logger.t(tag).d(msg);
        }
    }
    public static void e(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Logger.e(msg);
        }
    }

    public static void w(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Logger.w(msg);
        }
    }

    public static void v(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Logger.v(msg);
        }
    }

    public static void i(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Logger.i(msg);
        }
    }
}
