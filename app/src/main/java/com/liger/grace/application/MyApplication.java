package com.liger.grace.application;

import android.app.Application;

/**
 * Created by Liger on 2016/3/11 00:25.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        CrashReport.initCrashReport(getApplicationContext(), "93524e620d", false);
    }
}
