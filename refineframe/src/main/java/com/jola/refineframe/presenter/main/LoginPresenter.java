package com.jola.refineframe.presenter.main;

import android.text.TextUtils;

import com.jola.refineframe.R;
import com.jola.refineframe.app.MyApplication;
import com.jola.refineframe.base.presenter.BasePresenter;
import com.jola.refineframe.component.RxBus;
import com.jola.refineframe.contract.main.LoginContract;
import com.jola.refineframe.core.DataManager;
import com.jola.refineframe.core.bean.main.login.LoginData;
import com.jola.refineframe.core.event.LoginEvent;
import com.jola.refineframe.utils.RxUtils;
import com.jola.refineframe.widget.BaseObserver;

import javax.inject.Inject;


public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private DataManager mDataManager;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
        mDataManager = dataManager;
    }

    @Override
    public void getLoginData(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mView.showSnackBar(MyApplication.getInstance().getString(R.string.account_password_null_tint));
            return;
        }
        addSubscribe(mDataManager.getLoginData(username, password)
                .compose(RxUtils.rxSchedulerHelper())
                .compose(RxUtils.handleResult())
                .subscribeWith(new BaseObserver<LoginData>(mView,
                        MyApplication.getInstance().getString(R.string.login_fail)) {
                    @Override
                    public void onNext(LoginData loginData) {
                        setLoginAccount(loginData.getUsername());
                        setLoginPassword(loginData.getPassword());
                        setLoginStatus(true);
                        RxBus.getDefault().post(new LoginEvent(true));
                        mView.showLoginSuccess();
                    }
                }));
    }
}
