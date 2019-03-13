package com.jola.refineframe.di.module;


import com.jola.refineframe.app.MyApplication;
import com.jola.refineframe.core.DataManager;
import com.jola.refineframe.core.db.DbHelper;
import com.jola.refineframe.core.db.DbHelperImpl;
import com.jola.refineframe.core.http.HttpHelper;
import com.jola.refineframe.core.http.HttpHelperImpl;
import com.jola.refineframe.core.prefs.PreferenceHelper;
import com.jola.refineframe.core.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;



@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(HttpHelperImpl httpHelperImpl) {
        return httpHelperImpl;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(DbHelperImpl realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
