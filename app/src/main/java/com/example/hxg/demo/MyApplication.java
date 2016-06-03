package com.example.hxg.demo;

import android.app.Application;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;

// 请在AndroidManifest.xml中application标签下android:name中指定该类
public class MyApplication extends Application {


    private static Application _instance;
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
        Logger.setTag("NoHttpSample");
        Logger.setDebug(true);// 开始NoHttp的调试模式, 这样就能看到请求过程和日志
        _instance = this;



    }

    public static Application getInstance() {
        return _instance;
    }
}
