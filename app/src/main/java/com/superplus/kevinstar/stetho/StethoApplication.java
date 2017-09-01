package com.superplus.kevinstar.stetho;

import android.app.Application;

/**
 * Created by admin on 2017/9/1.
 */

public class StethoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DebugUtils.initStetho(this);
        DebugUtils.initLeakCanary(this);
    }
}
