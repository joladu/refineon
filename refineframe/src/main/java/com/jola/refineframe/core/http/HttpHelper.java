package com.jola.refineframe.core.http;

import com.jola.refineframe.core.bean.BaseResponse;
import com.jola.refineframe.core.bean.main.login.LoginData;


import io.reactivex.Observable;



public interface HttpHelper {

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 项目类别数据
     */
    Observable<BaseResponse<LoginData>> getLoginData(String username, String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param rePassword re password
     * @return 登陆数据
     */
    Observable<BaseResponse<LoginData>> getRegisterData(String username, String password, String rePassword);




}
