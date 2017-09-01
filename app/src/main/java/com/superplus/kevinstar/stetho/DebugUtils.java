package com.superplus.kevinstar.stetho;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Method;

/**
 * Created by kevinstar on 2017/9/1.
 * 该类用于配置测试类（配合检测类共同使用）
 * 使发布时可以随意发布不用在注释无关代码
 */

public class DebugUtils {
    public static void initStetho(Context context){
        try {
            Class<?> stetho = Class.forName("com.facebook.stetho.Stetho");
            Method initializeWithDefaults = stetho.getMethod("initializeWithDefaults",Context.class);
            initializeWithDefaults.invoke(null,context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void initLeakCanary(Application context){
        try{
            Class<?> leakCanary = Class.forName("com.squareup.leakcanary.LeakCanary");
            Method isInAnalyzerProcess = leakCanary.getMethod("isInAnalyzerProcess",Context.class);
            if ((boolean)isInAnalyzerProcess.invoke(null,context)){
                return;
            }
            Method install = leakCanary.getMethod("install",Application.class);
            install.invoke(null,context);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
