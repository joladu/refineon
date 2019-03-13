package com.jola.refineframe.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


public class MyApplication extends Application {

    private static MyApplication myApplication;

    public static synchronized MyApplication  getInstance(){
        return myApplication;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication = this;

    }




}
