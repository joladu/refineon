package com.jola.refineframe.di.component;


import com.jola.refineframe.app.MyApplication;
import com.jola.refineframe.core.DataManager;
import com.jola.refineframe.di.module.AppModule;
import com.jola.refineframe.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component( modules  = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,

        AppModule.class,
        HttpModule.class
})
public interface AppComponent {

  
    void inject(MyApplication myApplication);

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    MyApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();



}
