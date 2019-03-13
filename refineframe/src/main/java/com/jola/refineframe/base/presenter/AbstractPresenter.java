package com.jola.refineframe.base.presenter;

import com.jola.refineframe.base.view.AbstractView;

import io.reactivex.disposables.Disposable;

/**
 * Created by lenovo on 2019/3/13.
 */

public interface AbstractPresenter<T extends AbstractView> {

    void attachView(T view);

    void detachView();

    void addRxBingingSubscribe(Disposable disposable);

    boolean getIsNightMode();

    boolean  getLoginStatus();

    String getLoginAccout();

    void setLoginAccount();










}
