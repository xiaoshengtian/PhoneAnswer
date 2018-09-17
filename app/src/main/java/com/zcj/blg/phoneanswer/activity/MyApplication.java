package com.zcj.blg.phoneanswer.activity;

import android.app.Application;
import android.content.Context;

import cn.bmob.v3.Bmob;

/**
 * Created by zcj on 2018/9/16.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Bmob.initialize(this, "ff5e00bcddd166d1ae3c3e4d5cf73dd0");
    }

    public static Context getContext() {
        return mContext;
    }

}
