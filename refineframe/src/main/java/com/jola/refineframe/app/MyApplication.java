package com.jola.refineframe.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.jola.refineframe.di.component.AppComponent;
import com.jola.refineframe.di.component.DaggerAppComponent;
import com.jola.refineframe.di.module.AppModule;
import com.jola.refineframe.di.module.HttpModule;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class MyApplication extends Application implements HasActivityInjector {


    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    private static MyApplication myApplication;

    private static volatile AppComponent appComponent;

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


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }

    public static synchronized  AppComponent getAppComponent(){
        if (null == appComponent){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(myApplication))
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

}
