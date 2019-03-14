package com.jola.refineframe.base.presenter;

import com.jola.refineframe.base.view.AbstractView;
import com.jola.refineframe.core.DataManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;



public class BasePresenter<T extends AbstractView> implements AbstractPresenter<T> {

    protected T mView;
    private CompositeDisposable compositeDisposable;
    private DataManager mDataManager;

    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }

    @Override
    public boolean getNightModeState(){
//        return mDataManager.getNightModeState();
        return false;
    }

    @Override
    public void setLoginStatus(boolean loginStatus) {
//        mDataManager.setLoginStatus(loginStatus);
    }

    @Override
    public boolean getLoginStatus() {
//        return mDataManager.getLoginStatus();
        return false;
    }

    @Override
    public String getLoginAccount() {
        return mDataManager.getLoginAccount();
    }

    @Override
    public void setLoginAccount(String account) {
        mDataManager.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mDataManager.setLoginPassword(password);
    }

    @Override
    public int getCurrentPage() {
//        return mDataManager.getCurrentPage();
        return 1;
    }

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }


}
