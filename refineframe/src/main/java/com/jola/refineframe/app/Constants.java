package com.jola.refineframe.app;


import java.io.File;

public class Constants {


    public static final long DOUBLE_INTERVAL_TIME = 2000;

    public static final long CACHE_SIZE = 1024 * 1024 * 50;

    //    4 周
    public static final int CACHE_TIME = 60 * 60 * 24 * 28;

    /**
     * Avoid double click time area
     */
    public static final long CLICK_TIME_AREA = 1000;



    public static final String MY_SHARED_PREFERENCE = "shared_preference";


    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";



    /**
     * Shared Preference key
     */
    public static final String ACCOUNT = "account";

    public static final String PASSWORD = "password";


}
