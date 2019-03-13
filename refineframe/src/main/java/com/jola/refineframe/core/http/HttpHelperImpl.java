package com.jola.refineframe.core.http;


import com.jola.refineframe.core.bean.BaseResponse;
import com.jola.refineframe.core.bean.main.login.LoginData;
import com.jola.refineframe.core.http.api.Apis;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HttpHelperImpl implements HttpHelper {
    
    private  Apis mApis;

    @Inject
    HttpHelperImpl(Apis apis) {
        mApis = apis;
    }


    @Override
    public Observable<BaseResponse<LoginData>> getLoginData(String username, String password) {
        return mApis.getLoginData(username, password);
    }

    @Override
    public Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String repassword) {
        return mApis.getRegisterData(username, password, repassword);
    }
    
    
    
}
