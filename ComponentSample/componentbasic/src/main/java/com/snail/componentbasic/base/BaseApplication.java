package com.snail.componentbasic.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.LeakCanary;


public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }

    public void initLeakCanary() {
        LeakCanary.install(this);
    }
}
