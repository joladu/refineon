package com.jola.refineframe.base.fragment;

import android.content.Context;
import android.os.Bundle;

import com.jola.refineframe.base.presenter.AbstractPresenter;
import com.jola.refineframe.base.view.AbstractView;
import com.jola.refineframe.utils.CommonUtils;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;



public abstract class BaseDialogFragment<T extends AbstractPresenter> extends AbstractSimpleDialogFragment
        implements AbstractView {

    @Inject
    protected T mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPresenter != null) {
            mPresenter = null;
        }
    }

    @Override
    public void showErrorMsg(String errorMsg) {
        if (getActivity() != null) {
            CommonUtils.showSnackMessage(getActivity(), errorMsg);
        }
    }

    @Override
    public void useNightMode(boolean isNightMode) {
    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void reload() {

    }



    @Override
    public void showLoginView() {

    }

    @Override
    public void showLogoutView() {

    }

    @Override
    public void showToast(String message) {
        if (getActivity() == null) {
            return;
        }
        CommonUtils.showMessage(getActivity(), message);
    }

    @Override
    public void showSnackBar(String message) {
        if (getActivity() == null) {
            return;
        }
        CommonUtils.showSnackMessage(getActivity(), message);
    }

}
