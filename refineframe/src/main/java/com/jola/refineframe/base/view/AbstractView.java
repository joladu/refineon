package com.jola.refineframe.base.view;


public interface AbstractView {

    void useNightMode(boolean isNightMode);

    void showErrorMsg(String errMsg);

    void showLoading();

    void showNormal();

    void showError();

    void reload();

    void showLoginView();

    void showLogoutView();

    void showToast(String msg);

    void showSnackBar(String msg);




}
